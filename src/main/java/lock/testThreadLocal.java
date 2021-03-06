package lock;

import util.LogUtil;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yocn on 2019/7/2.
 * ThreadLocal
 */
public class testThreadLocal {
    private int repeat = 20;
    private static final AtomicInteger local = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    static Obj oo = new Obj(0);
    private static final ThreadLocal<Obj> threadLocal1 = new ThreadLocal<Obj>(){
        @Override
        protected Obj initialValue() {
            return oo;
        }
    };

    public void test() {
        Thread t1 = new Thread(() -> {
            LogUtil.Companion.d("ThreadLocal线程1->" + repeat1(threadLocal1, 10));
            LogUtil.Companion.d("ThreadLocal线程1->" + threadLocal1.get().hashCode());
        });
        Thread t2 = new Thread(() -> {
            LogUtil.Companion.d("ThreadLocal线程2->" + repeat1(threadLocal1, 20));
            LogUtil.Companion.d("ThreadLocal线程2->" + threadLocal1.get().hashCode());

        });
        Thread t3 = new Thread(() -> {
            LogUtil.Companion.d("AtomicInteger线程3->" + repeat2(local));
        });
        Thread t4 = new Thread(() -> {
            LogUtil.Companion.d("AtomicInteger线程4->" + repeat2(local));
        });
        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
    }

    public static class Obj {
        int i;

        public Obj(int i) {
            this.i = i;
        }
    }

    private String repeat1(ThreadLocal<Obj> threadLocal, int repeat) {
        int x = 0;
        StringBuilder sb = new StringBuilder();
        while (x < repeat) {
            int index = threadLocal.get().i;
            threadLocal.get().i = index += 1;
            threadLocal.set(threadLocal.get());
            x++;
            sb.append(index).append(" ").append(threadLocal.get().hashCode()).append(" ");
        }
        return sb.toString();
    }

    private String repeat2(AtomicInteger local) {
        int x = 0;
        StringBuilder sb = new StringBuilder();
        while (x < repeat) {
            local.getAndAdd(1);
            x++;
            sb.append(local.get()).append(" ");
        }
        return sb.toString();
    }
}
