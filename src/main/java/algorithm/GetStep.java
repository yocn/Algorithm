package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/19.
 * 有一组不同高度的台阶，有一个整数数组表示，数组中每个数是台阶的高度，当开始下雨了（雨水足够多）台阶之间的水坑会积水多少呢？
 * 如下图，可以表示为数组[0,1,0,2,1,0,1,3,2,1,2,1]，返回积水量6。
 */
public class GetStep {
    public void test() {
        int[] steps = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1, 3};
        int water = getWater(steps);
        LogUtil.Companion.d("water->" + water);
    }

    static int water = 0;

    public int getWater(int[] step) {
        water = 0;
        int[] maxIndex = getMaxIndex(step, 0, step.length);
        getLeftWater(step, maxIndex[1]);
        LogUtil.Companion.d("左边water->" + water);
        getRightWater(step, maxIndex[1]);
        LogUtil.Companion.d("右边water->" + water);
        return water;
    }

    public void getLeftWater(int[] src, int maxIndex) {
        int[] leftMaxIndex = getMaxIndex(src, 0, maxIndex);
        int max = leftMaxIndex[0];
        int index = leftMaxIndex[1];
        if (max <= 0) {
            return;
        }
        if (maxIndex - index > 1) {
            for (int i = index; i < maxIndex; i++) {
                int waterDivider = max - src[i];
                water += waterDivider;
            }
        }
        LogUtil.Companion.d("左边->" + leftMaxIndex[0] + " leftMaxIndex->" + leftMaxIndex[1] + " water->" + water);
        getLeftWater(src, index);
    }

    public void getRightWater(int[] src, int maxIndex) {
        int[] rightMaxIndex = getMaxIndex(src, maxIndex + 1, src.length);
        int max = rightMaxIndex[0];
        int index = rightMaxIndex[1];
        if (max <= 0) {
            return;
        }
        if (index - maxIndex > 1) {
            //两个index紧挨着，不处理
            for (int i = maxIndex; i < index; i++) {
                int waterDivider = max - src[i];
                water += waterDivider;
            }
        }
        LogUtil.Companion.d("右边->" + rightMaxIndex[0] + " rightMaxIndex->" + rightMaxIndex[1] + " water->" + water);
        getRightWater(src, index);
    }

    /**
     * 获取数组中最大的数和它的index
     *
     * @param src   目标数组
     * @param left  数组开始坐标
     * @param right 数组结束坐标
     * @return 最大值和最大值在目标数组中的位置
     */
    public int[] getMaxIndex(int[] src, int left, int right) {
        int[] maxAndIndex = new int[2];
        for (int i = left; i < right; i++) {
            if (src[i] > maxAndIndex[0]) {
                maxAndIndex[0] = src[i];
                maxAndIndex[1] = i;
            }
        }
        LogUtil.Companion.d(left + "到" + right + "范围最大值->" + maxAndIndex[0] + " index->" + maxAndIndex[1]);
        return maxAndIndex;
    }

}
