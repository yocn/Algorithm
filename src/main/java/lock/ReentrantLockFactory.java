package lock;

import util.LogUtil;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yocn on 2019/1/17.
 * 生产者+消费者
 */
public class ReentrantLockFactory {
    private int index = 0;
    private ArrayList<Product> products = new ArrayList<>();
    private ReentrantLock mReentrantLock = new ReentrantLock();

    private Thread consumeThread = new Thread(() -> {
        while (true) {
            mReentrantLock.lock();
            try {
                if (index == 10) {
                    index = 0;
                    products.clear();
                }
            } finally {
                mReentrantLock.unlock();
            }
        }
    });
    private Thread produceThread1 = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(500);
                mReentrantLock.lock();
                index++;
                products.add(new Product("p1"));
                LogUtil.Companion.d(index + "-" + products.size() + "-" + products.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mReentrantLock.unlock();
            }
        }
    });

    private Thread produceThread2 = new Thread(() -> {
        while (true) {
            try {
                Thread.sleep(500);
                mReentrantLock.lock();
                index++;
                products.add(new Product("p2"));
                LogUtil.Companion.d(index + "-" + products.size() + "-" + products.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mReentrantLock.unlock();
            }
        }
    });

    public void start() {
        consumeThread.start();
        produceThread1.start();
        produceThread2.start();
    }
}
