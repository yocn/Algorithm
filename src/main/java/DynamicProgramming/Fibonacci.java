package DynamicProgramming;

import util.LogUtil;

/**
 * Created by yocn on 2019/2/28.
 */
public class Fibonacci {
    public void test() {
        long time1 = System.currentTimeMillis();
        int num = normalFibonacciWithRecursion(40);
        long time2 = System.currentTimeMillis();
        LogUtil.Companion.d("normal->" + num + " time->" + (time2 - time1));
        time1 = System.currentTimeMillis();
        long numLong = normalFibonacciDynamicProgramming(80);
        time2 = System.currentTimeMillis();
        LogUtil.Companion.d("normal->" + numLong + " time->" + (time2 - time1));
    }

    private int normalFibonacciWithRecursion(int n) {
        if (n <= 1) {
            return 1;
        }
        return normalFibonacciWithRecursion(n - 1) + normalFibonacciWithRecursion(n - 2);
    }

    private long normalFibonacciDynamicProgramming(int n) {
        if (n <= 1) {
            return 1;
        }
        long result = 2;
        long pre;
        long current = 1;
        for (int i = 2; i < n; i++) {
            pre = current;
            current = result;
            result = current + pre;
        }
        return result;
    }
}
