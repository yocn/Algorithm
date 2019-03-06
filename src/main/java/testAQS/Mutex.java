package testAQS;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by yocn on 2019/3/4.
 * 一个最简单的互斥锁
 */
public class Mutex implements Lock {
    private Sync sync = new Sync();

    class Sync extends AbstractQueuedSynchronizer {
        public boolean tryAcquire(int acquire) {
            assert acquire == 1;
            if (compareAndSetState(0, 1)) {//如果是0 -> 变成1
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int release) {
            assert release == 1;
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        Condition getNewCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, @NotNull TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    public int getQueueLength() {
        return sync.getQueueLength();
    }

    @NotNull
    @Override
    public Condition newCondition() {
        return sync.getNewCondition();
    }
}
