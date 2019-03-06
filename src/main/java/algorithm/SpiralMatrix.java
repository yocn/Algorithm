package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/3/6.
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12],
 * [13,14,15,16]
 * ]
 */
public class SpiralMatrix {

    int[][] src = {
            {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
    };

    public void test() {
        spiralOrder(initArray(6, 10));
//        List<Integer> list = spiralOrder(src);
//        LogUtil.Companion.d(list.toString());
    }

    private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //m是行数，n是列数
        int m = matrix.length, n = matrix[0].length;
        //行或列哪个最小。
        int min = (m < n ? m : n);
        //一共有几层
        int level = (min % 2 == 0 ? min : min + 1) / 2;

        LogUtil.Companion.d("m->" + m + " n->" + n);
        for (int i = 0; i < level; i++) {
            readALevel(result, i, matrix, m, n);
        }
        return result;
    }

    int lastIndex;

    private void readALevel(List<Integer> list, int level, int[][] matrix, int m, int n) {
        int x = m - level * 2;//第level圈有几列
        int y = n - level * 2;//第level圈有几行
        int max = (x > 1) ? ((x + y - 2) * 2) : y;//这一个level一共有多少个数。一列减去两个顶点
        LogUtil.Companion.d("第" + level + "圈有" + x + "列，有" + y + "行，一共有" + max + "个数字");
        StringBuilder sb = new StringBuilder();
        int index = lastIndex;
        for (int i = 0; i < max; i++) {
            if (i < y) {
                sb.append(index).append(" ");
                list.add(index);
                index++;
            } else if (i < x + y - 1) {
                sb.append(index).append(" ");
                list.add(index);
                index += y;
            } else if (i < x + 2 * y - 2) {
                sb.append(index).append(" ");
                list.add(index);
                index--;
            } else {
                sb.append(index).append(" ");
                list.add(index);
                index -= y;
            }
        }
        LogUtil.Companion.d("->" + sb.toString());
        lastIndex = index + 1;
    }

    private int[][] initArray(int x, int y) {
        int num = 0;
        StringBuilder sb = new StringBuilder();
        int[][] xy = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                num++;
                xy[i][j] = num;
                sb.append(num);
                sb.append((num < 10) ? "  " : " ");
            }
            sb.append("\n");
        }
        int min = (x < y ? x : y);
        int level = (min % 2 == 0 ? min : min + 1) / 2;
        sb.append("----------------------->").append(level);
        LogUtil.Companion.d(sb.toString());
        return xy;
    }
}
