package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/8.
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * 输入: 4
 * 输出:
 * [
 * [ 1,  2,  3,  4],
 * [ 12, 13, 14, 5 ],
 * [ 11, 16, 15, 6 ]
 * [ 10, 9,  8,  7 ]
 * ]
 */
public class SprialMatrixII {
    public void test() {
        int[][] result = generateMatrix(7);
        LogUtil.Companion.d("\n");
        StringBuilder sb = new StringBuilder();
        for (int[] i : result) {
            for (int  j: i) {
                if (j < 10) {
                    sb.append("  ").append(j);
                } else {
                    sb.append(" ").append(j);
                }
                sb.append(" ");
            }
            sb.append("\n").append("\n");
        }
        LogUtil.Companion.d(sb.toString());
    }

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int index = 0, layer = 0;
        while (index < n * n) {
            for (int i = layer; i < n - layer; i++) {
                arr[layer][i] = ++index;
                LogUtil.Companion.d("loop1->[" + layer + "," + i + "]");
            }
            for (int i = layer + 1; i < n - layer; i++) {
                arr[i][n - layer - 1] = ++index;
                LogUtil.Companion.d("loop2->[" + i + "," + (n - layer - 1) + "]");
            }
            for (int i = n - layer - 2; i >= layer; i--) {
                arr[n - layer - 1][i] = ++index;
                LogUtil.Companion.d("loop3->[" + (n - layer - 1) + "," + i + "]");
            }
            for (int i = n - layer - 2; i > layer; i--) {
                arr[i][layer] = ++index;
                LogUtil.Companion.d("loop4->[" + i + "," + layer + "]");
            }
            LogUtil.Companion.d("out (n - layer)->" + (n - layer) + ",(n - layer - 2)->" + (n - layer - 2) + "");
            layer++;
        }
        return arr;
    }

}
