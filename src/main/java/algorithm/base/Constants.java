package algorithm.base;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/20.
 */
public class Constants {
    public static int[] src = new int[]{5, 2, 1, 8, 0, 4, 10, 9, 33, 7, 32, 5, 8, 9, 12, 15, 17, 25, 28};

    public static void printInts(int[] ints) {
        StringBuilder sb = new StringBuilder();
        for (int i : ints) {
            sb.append(i).append(" ");
        }
        LogUtil.Companion.d(sb.toString());
    }
}
