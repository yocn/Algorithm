package lock;

import util.LogUtil;

import java.util.ArrayList;

/**
 * Created by yocn on 2019/1/17.
 * 生产者+消费者
 */
public class SimpleSyncFactory {
    private int index = 0;
    private ArrayList<Product> products = new ArrayList<>();

    private Thread consumeThread = new Thread(() -> {
        while (true) {
            synchronized (SimpleSyncFactory.class) {
                if (index == 10) {
                    index = 0;
                    products.clear();
                }
                if (index % 2 == 0) {
                    SimpleSyncFactory.class.notify();
                }
            }
        }
    });
    private Thread produceThread1 = new Thread(() -> {
        while (true) {
            synchronized (SimpleSyncFactory.class) {
                try {
                    Thread.sleep(500);
                    index++;
                    products.add(new Product("p1"));
                    LogUtil.Companion.d(index + "-" + products.size() + "-" + products.toString());
                    SimpleSyncFactory.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    private Thread produceThread2 = new Thread(() -> {
        while (true) {
            synchronized (SimpleSyncFactory.class) {
                try {
                    Thread.sleep(500);
                    index++;
                    products.add(new Product("p2"));
                    LogUtil.Companion.d(index + "-" + products.size() + "-" + products.toString());
                    SimpleSyncFactory.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public void start() {
        consumeThread.start();
        produceThread1.start();
        produceThread2.start();
    }
}
