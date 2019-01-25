package lock;

import util.LogUtil;

import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yocn on 2019/1/18.
 * 测试TreeMap
 * 逻辑：一个size为10的collection，满足8的时候取第一个做差值，满足10个的时候直接取帧，多于10个丢掉第一帧
 */
public class TestSimpleTreeMap {
    private TreeMap<Integer, FrameBean> mFrameTreeMap = new TreeMap<>();
    private static int TIME_DIVIDER = 60;
    private static int FRAME_PLAY = 8;
    private static int FRAME_CAPACITY = 10;

    private int zeroFrameMark = 0;

    int testIndex = 0;

    private CopyOnWriteArrayList<FrameBean> list = new CopyOnWriteArrayList<FrameBean>();

    public void test() {
        Thread addThread = new Thread(() -> {
            for (; ; ) {
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long ts = System.currentTimeMillis();
                FrameBean bean = new FrameBean(ts, ++testIndex);
                list.add(bean);
            }
        });
        addThread.start();
    }

    private void addFrame(FrameBean bean) {
        if (mFrameTreeMap.size() >= 10) {
            mFrameTreeMap.remove(mFrameTreeMap.firstKey());
        }
        mFrameTreeMap.put(bean.index, bean);
    }


    /**
     * 传入时间返回帧数据
     *
     * @param time 当前播放的时间
     * @return 帧数据
     */
    private FrameBean getFrame(long time) {
        FrameBean bean = null;
        if (mFrameTreeMap.size() < FRAME_PLAY) {
            LogUtil.Companion.d("mFrameTreeMap.size->" + mFrameTreeMap.size());
            return bean;
        }
        if (mFrameTreeMap.size() >= FRAME_CAPACITY) {
            /*大于10，直接返回最老的那帧*/
            bean = mFrameTreeMap.firstEntry().getValue();
        }
        LogUtil.Companion.d("期待->" + zeroFrameMark + " 实际->" + bean.index + " 差距->" + (zeroFrameMark - bean.index)
                +
                "      缓冲数->" + mFrameTreeMap.size());
        if (mFrameTreeMap.size() >= FRAME_CAPACITY) {
            mFrameTreeMap.remove(mFrameTreeMap.firstEntry().getKey());
        }
        return bean;
    }

    public static class FrameBean {
        private long ts = 0;
        private int index = 0;

        public FrameBean() {
        }

        public FrameBean(long ts, int index) {
            this.ts = ts;
            this.index = index;
        }

        @Override
        public String toString() {
            return "FrameBean{" +
                    "ts=" + ts +
                    ", index=" + index +
                    '}';
        }
    }
}
