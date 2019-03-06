package testAQS;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yocn on 2019/3/4.
 * 测试AQS
 */
public class TestAQS {
    int num = 0;
    boolean isRunning = true;

    public void test() {
//        testMutex();
//        testNotify();
        testReentrantLock();
    }

    private void testMutex() {
        Mutex mutex = new Mutex();
        Thread thread1 = new Thread(() -> {
            int num = 0;
            while (isRunning) {
                mutex.lock();
                num++;
                try {
                    LogUtil.Companion.d("thread1 print num-> " + num);
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
            int num = 0;
            while (isRunning) {
                mutex.lock();
                num++;
                try {
                    LogUtil.Companion.d("thread2 print num-> " + num);
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

    private void testNotify() {
        List<Product> list = new ArrayList<>();
        Thread produceThread = new Thread(() -> {
            while (isRunning) {
                synchronized (list) {
                    try {
                        Thread.sleep(200);
                        list.add(new Product(++num));
                        LogUtil.Companion.d("生产者生产-> " + num);
                        if (num == 10) {
                            list.notifyAll();
                            list.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread consumeThread = new Thread(() -> {
            while (isRunning) {
                synchronized (list) {
                    try {
                        num = 0;
                        list.clear();
                        LogUtil.Companion.d("消费者消费-> " + num);
                        Thread.sleep(100);
                        list.notifyAll();
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        produceThread.start();
        consumeThread.start();
    }

    private void testReentrantLock() {
        List<Product> list = new ArrayList<>();
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean isRunning = true;
        Thread produceThread = new Thread(() -> {
            while (isRunning) {
                lock.lock();
                try {
                    list.add(new Product(++num));
                    LogUtil.Companion.d("生产者生产-> " + num);
                    Thread.sleep(100);
                    if (num == 10) {
                        condition.signalAll();
                        condition.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        Thread customThread = new Thread(() -> {
            while (isRunning) {
                lock.lock();
                try {
                    num = 0;
                    list.clear();
                    LogUtil.Companion.d("消费者消费-> " + num);
                    Thread.sleep(120);
                    condition.signalAll();
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        });
        produceThread.start();
        customThread.start();
    }

    private static class Product {
        private int id;

        public Product() {
        }

        public Product(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    '}';
        }
    }
}
