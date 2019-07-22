package algorithm.PrefixSum;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/21.
 * 输入n个数的数列，所有相邻m数的和有n-m+1个，求其中的最小值。
 * 比如：
 * 数组为：[10, 4, 1, 5, 5, 2]
 * m为：3
 * 结果为：10
 */
public class MinM {
    public void test() {
        int[] src = new int[]{10, 4, 1, 5, 5, 2};
        LogUtil.Companion.d("1->" + minM(src, 1));
        LogUtil.Companion.d("2->" + minM(src, 2));
        LogUtil.Companion.d("3->" + minM(src, 3));
        LogUtil.Companion.d("4->" + minM(src, 4));
    }

    /**
     * 获取最小值
     *
     * @param src 原数组
     * @param m   几个
     * @return 最小值
     */
    private int minM(int[] src, int m) {
        if (m <= 0) {
            return 0;
        }
        int[] prefixSum = new int[src.length];
        for (int i = 0; i < prefixSum.length; i++) {
            if (i == 0) {
                prefixSum[i] = src[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + src[i];
            }
        }
        int first = prefixSum[m - 1], result = first;
        for (int i = m; i < prefixSum.length; i++) {
            int current = prefixSum[i] - prefixSum[i - m];
            result = current > result ? result : current;
        }

        return result;
    }
}
