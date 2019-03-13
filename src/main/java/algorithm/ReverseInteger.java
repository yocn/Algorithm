package algorithm;

import com.sun.deploy.util.StringUtils;
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
//        int s = reverse(2147483412);
        int s = reverseString(-2147483412);
//        int s = reverseString(x);
        LogUtil.Companion.d(s + " " + x);
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
        int last = x;
        for (int i = length - 1; i >= 0; i--) {
            int pow = (int) Math.pow(10, i);
            int digit = last / pow;
            if (digit > 2 && i == 0 && length == 10) {
                return 0;
            }
            last = last - digit * pow;
            long temp = digit * (long) Math.pow(10, length - 1 - i);
            if (temp > Integer.MAX_VALUE) {
                return 0;
            }
            result = result + (int) temp;
            if (result < 0) {
                return 0;
            }
            LogUtil.Companion.d(digit + " - " + result + " temp->" + temp + " i->" + i);
        }
        return isMinus ? -result : result;
    }

    public int reverseString(int x) {
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

        char[] chars = new StringBuffer(x + "").reverse().toString().toCharArray();
        int result = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int digit = chars[i] - '0';
            LogUtil.Companion.d("digit->" + digit);
            if (digit > 2 && i == 0 && length == 10) {
                return 0;
            }
            int pow = (int) Math.pow(10, length - 1 - i);
            long temp = digit * pow;
            if (temp > Integer.MAX_VALUE) {
                return 0;
            }
            result += (int) temp;
            if (result < 0) {
                return 0;
            }
            LogUtil.Companion.d("digit->" + digit + " temp->" + temp + " pow->" + pow);
        }
        return isMinus ? -result : result;
    }

}
