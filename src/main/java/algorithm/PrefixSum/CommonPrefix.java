package algorithm.PrefixSum;

import algorithm.base.Constants;
import testConstant.Constant;
import util.LogUtil;

/**
 * Created by yocn on 2019/7/21.
 * 前缀和
 */
public class CommonPrefix {
    public void test() {
        int length = 5;
        int[] src = new int[length];
        for (int i = 0; i < length; i++) {
            src[i] = i;
        }
        int[] result = oneDimen(src);
        Constants.printInts(src);
        Constants.printInts(result);


        int[][] srcc = new int[length][length];
        for (int i = 0; i < length; i++) {
            int[] srcInner = new int[length];
            for (int j = 0; j < length; j++) {
                srcInner[j] = i * length + j;
            }
            srcc[i] = srcInner;
        }
        Constants.printInts(srcc);
        int[][] prefix = twoDimen(srcc);
        Constants.printInts(prefix);

    }

    /**
     * 一维前缀和
     *
     * @param src 原数组
     * @return 一维前缀和
     */
    private int[] oneDimen(int[] src) {
        int[] result = new int[src.length];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                result[i] = src[i];
            } else {
                result[i] = result[i - 1] + src[i];
            }
        }
        return result;
    }

    /**
     * 二维前缀和
     *
     * @param src 原数组
     * @return 二维前缀和
     */
    private int[][] twoDimen(int[][] src) {
        int[][] result = new int[src[0].length][src.length];
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                if (i == 0 && j == 0) {//第0个，最左上角
                    result[i][j] = src[i][j];
                } else if (i == 0) {//第一行，最顶部一行
                    result[i][j] = result[i][j - 1] + src[i][j];
                } else if (j == 0) {//第一列，最左边一列
                    result[i][j] = result[i - 1][j] + src[i][j];
                } else {//其他
                    result[i][j] = result[i - 1][j] + result[i][j - 1] + src[i][j] - result[i - 1][j - 1];
                }
            }
        }
        return result;
    }


}
