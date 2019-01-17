package lock;

import util.LogUtil;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by yocn on 2019/1/17.
 * 生产者 + 消费者 使用CountDownLatch判断唤醒时机
 */
public class SyncCountDownLatchFactory {
    private int index = 0;
    private ArrayList<Product> products = new ArrayList<>();
    private CountDownLatch mCountDownLatch = new CountDownLatch(2);

    private Thread consumeThread = new Thread(() -> {
        while (true) {
            synchronized (SyncCountDownLatchFactory.class) {
                if (index == 10) {
                    index = 0;
                    products.clear();
                }
                if (mCountDownLatch.getCount() == 0) {
                    mCountDownLatch = new CountDownLatch(2);
                    SyncCountDownLatchFactory.class.notifyAll();
                }
            }
        }
    });
    private Thread produceThread1 = new Thread(() -> {
        while (true) {
            synchronized (SyncCountDownLatchFactory.class) {
                try {
                    Thread.sleep(500);
                    index++;
                    products.add(new Product("p1"));
                    mCountDownLatch.countDown();
                    LogUtil.Companion.d(mCountDownLatch.getCount() + " " + index + "-" + products.size() + "-" + products.toString());
                    SyncCountDownLatchFactory.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    private Thread produceThread2 = new Thread(() -> {
        while (true) {
            synchronized (SyncCountDownLatchFactory.class) {
                try {
                    Thread.sleep(500);
                    index++;
                    products.add(new Product("p2"));
                    LogUtil.Companion.d(mCountDownLatch.getCount() + " " + index + "-" + products.size() + "-" + products.toString());
                    mCountDownLatch.countDown();
                    SyncCountDownLatchFactory.class.wait();
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
