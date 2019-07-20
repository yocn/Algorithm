package lock;

import util.LogUtil;

import java.util.*;

/**
 * Created by yocn on 2019/7/17.
 * 生产者消费者,生产者
 */
public class ProducerAndCustomer {

    public static class Factory {
        private final int MAX_VALUE = 5;
        private final Queue<Integer> pool = new ArrayDeque<>();

        private int current = 0;

        private void produce() {
            synchronized (pool) {
                if (pool.size() >= MAX_VALUE) {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    pool.add(++current);
                    LogUtil.Companion.d("生产->" + current + " -当前->" + get(pool.toArray()));
                    pool.notify();
                }
            }
        }

        private void consume() {
            synchronized (pool) {
                if (pool.isEmpty()) {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    int tar = pool.poll();
                    pool.notify();
                    LogUtil.Companion.d("消费->" + tar);
                }
            }
        }
    }

    private static String get(Object[] objs) {
        StringBuilder sb = new StringBuilder();
        for (Object i : objs) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    public void test() {
        Factory factory = new Factory();
        Thread t1 = new Thread(() -> {
            while (true) {
                factory.produce();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                factory.consume();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
