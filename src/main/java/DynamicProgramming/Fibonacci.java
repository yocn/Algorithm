package DynamicProgramming;

import util.LogUtil;

/**
 * Created by yocn on 2019/2/28.
 */
public class Fibonacci {
    public void test() {
        long time1 = System.currentTimeMillis();
        int num = normalFibonacciWithRecursion(4);
        long time2 = System.currentTimeMillis();
        LogUtil.Companion.d("normal->" + num + " time->" + (time2 - time1));
    }

    private int normalFibonacciWithRecursion(int n) {
        if (n <= 1) {
            return 1;
        }
        return normalFibonacciWithRecursion(n - 1) + normalFibonacciWithRecursion(n - 2);
    }

    private int normalFibonacciNormal(int n) {
        if (n <= 1) {
            return 1;
        }
        int total = 0;
        for (int i = 2; i < n; i++) {

        }
        return total;
    }
}
