package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/1/26.
 * 八皇后问题
 * 1 0 0 0
 * 0 0 1 0
 * 0 0 0 0
 * 0 0 0 0
 */
public class EightQueen {
    private static int MAX_NUM = 0;

    public static void test() {
        MAX_NUM = 8;
        chest = new int[MAX_NUM][MAX_NUM];
//        printfChart(6, 4);
        settleQueen(0);
        print();
    }

    private static int[][] chest;

    public static int EightQueue(int num) {
        MAX_NUM = num;
        return MAX_NUM;
    }

    /**
     * 检查第x列y行是否合规
     *
     * @param x 列（竖向）
     * @param y 行（横向）
     * @return 是否合规
     */
    private static boolean checkValid(int x, int y) {
        for (int i = 0; i < y; i++) {
            /*逐行检查*/
            if (chest[x][i] == 1) {
                /*检查第x列的每i行有没有皇后，比如x=2，y=3，检查第2列的1 2 3行有没有皇后，检查竖列*/
                return false;
            }
            if (x - i - 1 >= 0 && chest[x - i - 1][y - i - 1] == 1) {
                return false;
                /*行->[0~y]，列在同一个斜线上的话->[]*/
            }
            if (x + i + 1 < MAX_NUM && chest[x + i + 1][y - i - 1] == 1) {
                return false;
            }
        }
        return true;
    }

    int line = 0;

    public static boolean settleQueen(int y) {
        if (y >= MAX_NUM) {
            return true;
        }
        for (int i = 0; i < MAX_NUM; i++) {
            for (int x = 0; x < MAX_NUM; x++) {
                chest[x][y] = 0;
            }
            if (checkValid(i, y)) {
                /*从0开始逐列检查*/
                chest[i][y] = 1;
                print();
                if (settleQueen(y + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                sb.append(chest[i][j]);
            }
            sb.append("\n");
        }
        LogUtil.Companion.d(sb.toString());
    }

    /**
     * 第3行第4列
     *
     * @param x 行
     * @param y 列
     */
    public static void printfChart(int x, int y) {
        for (int i = 0; i < MAX_NUM; i++) {
            //遍历每一行，y是行 i-> [0~y]
            chest[i][y] = 1;
            chest[x][y] = 2;
            if (x + y - i - 1 >= 0 && x + y - i - 1 <= MAX_NUM - 1 && i + 1 >= 0 && i + 1 <= MAX_NUM - 1) {
                chest[i + 1][x + y - i - 1] = 3;
            }
            if (i - 2 >= 0 && i - 2 <= MAX_NUM - 1) {
                chest[i][i - 2] = 4;
            }

        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_NUM; i++) {
            for (int j = 0; j < MAX_NUM; j++) {
                sb.append(chest[i][j]).append(" ");
            }
            sb.append("\n");
        }
        LogUtil.Companion.d("" + sb.toString());
    }
}
