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
public class TestTreeMap {
    private TreeMap<Integer, FrameBean> mFrameTreeMap = new TreeMap<>();
    private static int TIME_DIVIDER = 60;
    private static int FRAME_PLAY = 8;
    private static int FRAME_CAPACITY = 10;

    private int zeroFrameMark = 0;
    private long mZeroTS = 0;

    Random random = new Random();
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

        Thread netThread = new Thread(() -> {
            for (; ; ) {
                if (!list.isEmpty()) {
                    int sleep = random.nextInt(200);
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    FrameBean bean = list.get(0);
                    if (bean.index % 7 == 0) {
                        //drop
                    } else {
                        addFrame(bean);
                    }
                    list.remove(0);
                    LogUtil.Companion.d("---------size->" + list.size());
                }
            }
        });
        Thread getThread = new Thread(() -> {
            for (; ; ) {
                FrameBean bean = getFrame(System.currentTimeMillis() + TIME_DIVIDER * FRAME_PLAY);
                try {
                    Thread.sleep(60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        addThread.start();
        netThread.start();
        getThread.start();
    }

    private void addFrame(FrameBean bean) {
//        LogUtil.Companion.d("---------------------------------------add->");
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
//        LogUtil.Companion.d("---------------------------------------get->");
        FrameBean bean = null;
        int label = 0;
//        long oldestTime = mFrameTreeMap.firstKey();
        if (mFrameTreeMap.size() < FRAME_PLAY) {
            LogUtil.Companion.d("mFrameTreeMap.size->" + mFrameTreeMap.size());
            return bean;
        }
        if (mFrameTreeMap.size() >= FRAME_PLAY && mFrameTreeMap.size() < FRAME_CAPACITY) {
            /*大于8小于10，需要插值*/
            if (zeroFrameMark == 0) {
                bean = mFrameTreeMap.firstEntry().getValue();
            } else {
                bean = interpolation(mFrameTreeMap.firstEntry().getValue(), getFrameIndex(mZeroTS, time));
            }
            label = 0;
        }
        if (mFrameTreeMap.size() >= FRAME_CAPACITY) {
            /*大于10，直接返回最老的那帧*/
            bean = mFrameTreeMap.firstEntry().getValue();
            label = 1;
        }
        if (zeroFrameMark == 0) {
            mZeroTS = System.currentTimeMillis();
        }
        zeroFrameMark = getFrameIndex(mZeroTS, time);
        LogUtil.Companion.d("期待->" + zeroFrameMark + " 实际->" + bean.index + " 差距->" + (zeroFrameMark - bean.index) + " label->" + (label == 0 ? "插值得出" : "真实数据") +
                "      缓冲数->" + mFrameTreeMap.size());
        if (mFrameTreeMap.size() >= FRAME_CAPACITY) {
            mFrameTreeMap.remove(mFrameTreeMap.firstEntry().getKey());
        }
        return bean;
    }

    private FrameBean interpolation(FrameBean bean, int needIndex) {
        return bean;
    }

    private String map2String(TreeMap<Integer, FrameBean> map) {
        StringBuffer sb = new StringBuffer();
        for (int index : map.keySet()) {
            sb.append(map.get(index).index).append(" ");
        }
        return sb.toString();
    }

    /**
     * 获取frame index
     *
     * @param zeroTS 第0帧开始的时间
     * @param ts     当前时间戳
     * @return 当前需要第x帧
     */
    private int getFrameIndex(long zeroTS, long ts) {
        return (int) ((ts - zeroTS) / TIME_DIVIDER);
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
