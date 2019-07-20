package algorithm.base;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/20.
 */
public class Constants {
    public static int[] src = new int[]{5, 2, 1, 8, 0, 4, 10, 9, 33, 7, 32, 5, 8, 9, 12, 15, 17, 25, 28};
    public static int[] src2 = new int[]{5, 2, 1, 8, 2, 2, 5, 2, 3, 8, 0, 4, 5, 5, 5, 5, 0, 4};

    public static void printInts(int[] ints, Object... tags) {
        StringBuilder sb = new StringBuilder();
        for (Object s : tags) {
            sb.append(s);
        }
        for (int i : ints) {
            sb.append(i);
            if (i >= 0 && i < 10) {
                sb.append("  ");
            } else {
                sb.append(" ");
            }
        }

        LogUtil.Companion.d(sb.toString());
    }

    public static void printInts(int[] ints, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(ints[i]).append(" ");
        }
        LogUtil.Companion.d(left + "到" + right + "-> " + sb.toString());
    }

}
