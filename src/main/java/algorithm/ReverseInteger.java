package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/12.
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * -2147483648 ~ 2147483647
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {
    public void test() {
        int x = Integer.MIN_VALUE + 1;
        int s = reverse(x);
        LogUtil.Companion.d(s);
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        boolean isMinus = false;
        if (x < 0) {
            x = Math.abs(x);
            isMinus = true;
        }
        if (x < 10) {
            return isMinus ? -x : x;
        }
        int result = 0;
        int length = (x + "").length();
        LogUtil.Companion.d("length->" + length);
        int last = x;
        for (int i = length - 1; i >= 0; i--) {
            int pow = (int) Math.pow(10, i);
            int digit = last / pow;
            last = last - digit * pow;
            result = result + digit * (int) Math.pow(10, length - 1 - i);
            LogUtil.Companion.d(digit);
        }
        return isMinus ? -result : result;
    }
}
