package testAQS;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/4.
 * 测试AQS
 */
public class TestAQS {
    public void test() {
        testMutex();
    }

    public void testMutex() {
        Mutex mutex = new Mutex();
        boolean isRunning = true;
        Thread thread1 = new Thread(() -> {
            while (isRunning) {
                mutex.lock();
                try {
                    LogUtil.Companion.d("thread1 print");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.unlock();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (isRunning) {
                mutex.lock();
                try {
                    LogUtil.Companion.d("thread2 print");
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.unlock();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
