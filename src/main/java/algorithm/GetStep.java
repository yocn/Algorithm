package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/19.
 * 有一组不同高度的台阶，有一个整数数组表示，数组中每个数是台阶的高度，当开始下雨了（雨水足够多）台阶之间的水坑会积水多少呢？
 * 如下图，可以表示为数组[0,1,0,2,1,0,1,3,2,1,2,1]，返回积水量6。
 */
public class GetStep {
    public void test() {
        int[] steps = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int water = getWater(steps);
        LogUtil.Companion.d("water->" + water);
    }

    public int getWater(int[] step) {
        int result = 0;
        return result;
    }

    

}
