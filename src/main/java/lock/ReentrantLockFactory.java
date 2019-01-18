package lock;

import util.LogUtil;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yocn on 2019/1/17.
 * 生产者+消费者
 */
public class ReentrantLockFactory {
    private int index = 0;
    private ArrayList<Product> products = new ArrayList<>();
    private ReentrantLock mReentrantLock = new ReentrantLock();
    private Condition mCondition = mReentrantLock.newCondition();

    private Thread preThread1 = new Thread(() -> {
        try {
            LogUtil.Companion.d("preThread1 start");
            Thread.sleep(1000);
            LogUtil.Companion.d("preThread1 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

    private Thread preThread2 = new Thread(() -> {
        try {
            LogUtil.Companion.d("preThread2 start");
            Thread.sleep(1000);
            LogUtil.Companion.d("preThread2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    });

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
                mCondition.await();
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
                mCondition.await();
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
        //Just Test Join，No meaning~
//        preThread1.start();
//        try {
//            preThread1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        preThread2.start();
//        try {
//            preThread2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        consumeThread.start();
        produceThread1.start();
        produceThread2.start();
    }
}
