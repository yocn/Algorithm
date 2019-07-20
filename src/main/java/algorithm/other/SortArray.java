package algorithm.other;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/18.
 */
public class SortArray {

    public void test() {
//        int[] array = new int[]{0, 2, 4, 9};
//        int[] array = new int[]{-7, -3, -1};
        int[] array = new int[]{-7, -3, -1, 0, 2, 4, 9};
//        int[] array = new int[]{-1, 0, 2, 4, 9};
        int[] result = sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        LogUtil.Companion.d(sb.toString());
    }

    //排好序的数组，有正有负，输出排好序的数组，里面值是输入数组值的平方
    //[-7,-3,-1,0,2,4,9]
    public int[] sort(int[] src) {
        int n = src.length;
        int[] result = new int[n];
        int zero = -1;
        for (int i = 0; i < n; i++) {
            if (src[i] < 0) {
                zero = i;
            } else {
                break;
            }
        }
        int i, j;
        //全是负的
        i = zero;
        j = zero + 1;
        int index = 0;
        LogUtil.Companion.d("zero->" + zero + " i->" + i + " j->" + j);
        while (i >= 0 || j <= n - 1) {
            if (i < 0) {
                result[index++] = src[j] * src[j];
                j++;
                continue;
            }
            if (j > n - 1) {
                result[index++] = src[i] * src[i];
                i--;
                continue;
            }
            if (src[i] * src[i] > src[j] * src[j]) {
                result[index++] = src[j] * src[j];
                j++;
            } else {
                result[index++] = src[i] * src[i];
                i--;
            }
        }
        return result;
    }
}
