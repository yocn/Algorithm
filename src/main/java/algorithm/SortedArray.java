package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/17.
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class SortedArray {
    public void test() {
        int[] src = {-7,-3,2,3,11};
        int[] out = getSortedArray(src);
        for (int i : out) {
            LogUtil.Companion.d(i);
        }
    }

    int[] getSortedArray(int[] in) {
        int[] out = new int[in.length];
        int minIndex = 0;
        int min = 0;
        for (int i = 0; i < in.length; i++) {
            if (i == 0) {
                min = in[i] * in[i];
            }
            if (Math.abs(in[i]) * Math.abs(in[i]) < min) {
                min = Math.abs(in[i]) * Math.abs(in[i]);
                minIndex = i;
            }
        }
        int left = minIndex;
        int right = minIndex;
        int curr = 0;
        out[curr] = min;
        while (left > 0 || right < in.length) {
            curr++;
            if (curr >= in.length) {
                break;
            }
            int nextLeft = (left - 1) > 0 ? (left - 1) : 0;
            int nextRight = (right + 1) > (in.length - 1) ? (in.length - 1) : (right + 1);
//            LogUtil.Companion.d("lr->" + left + "/" + right + " -> " + nextLeft + "/" + nextRight + " " + in[nextLeft] + "/" + in[nextRight]);
            if (in[nextLeft] * in[nextLeft] >= in[nextRight] * in[nextRight]) {
                if (curr == 0) {
                    min = in[nextLeft] * in[nextLeft];
                } else {
                    min = in[nextRight] * in[nextRight];
                }
//                LogUtil.Companion.d("左边大于右边->" + nextLeft + "/" + nextRight + " -> " + in[nextLeft] + " " + in[nextRight] + " min->" + min);
                right++;
                out[curr] = min;
            } else {
                if (curr == in.length - 1) {
                    min = in[nextRight] * in[nextRight];
                } else {
                    min = in[nextLeft] * in[nextLeft];
                }
                left--;
                out[curr] = min;

//                LogUtil.Companion.d("左边大于右边 fail>" + nextLeft + "/" + nextRight + " -> " + in[nextLeft] + " " + in[nextRight] + " min->" + min);
            }
//            LogUtil.Companion.d(out[curr] + " --------------------- " + curr + " " + min);
        }
        return out;
    }
}
