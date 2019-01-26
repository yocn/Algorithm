package algorithm;

import sun.rmi.runtime.Log;
import util.LogUtil;

/**
 * Created by yocn on 2019/1/25.
 * 9. Palindrome Number
 * Easy
 * <p>
 * 1172
 * <p>
 * 1176
 * <p>
 * Favorite
 * <p>
 * Share
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Coud you solve it without converting the integer to a string?
 */
public class IsPalindromic {

    public static void test() {
        LogUtil.Companion.d("" + isPalindrome(Integer.MAX_VALUE));
    }

    public static boolean isPalindrome(int x) {
        return getPanlindromic(x);
    }

    private static boolean getPanlindromic(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int test = x;
        int digit = 0;
        boolean finding = true;
        for (; finding; ) {
            long tens = (long) Math.pow(10, digit++);
            if (x / tens >= 1) {
                long temp = x % tens;
                if (digit > 20) {
                    return false;
                }
                LogUtil.Companion.d("tens->" + tens + " temp->" + temp + " x->" + x + " digit->" + digit + " x / tens ->" + (x / tens));
            } else {
                finding = false;
            }
        }
        digit--;
        int[] ints = new int[digit];
        LogUtil.Companion.d(digit + "---------------" + digit);
        for (int i = 0; i < digit; i++) {
            int big = (int) Math.pow(10, (digit - i - 1));
            int aa = (test / big);
            test -= aa * big;
            ints[i] = aa;
        }
        int leftIndex = 0;
        int rightIndex = 0;
        if (digit % 2 == 0) {
            /*偶数*/
            leftIndex = (digit >> 1) - 1;
            rightIndex = (digit >> 1);
        } else {
            leftIndex = rightIndex = (digit >> 1);
        }
        if (ints[leftIndex] != ints[rightIndex]) {
            return false;
        }
        while (--leftIndex >= 0 && ++rightIndex < digit) {
            if (ints[leftIndex] != ints[rightIndex]) {
                return false;
            }
        }

        return true;
    }

    private static boolean getPanlindromic2(int x) {
        char[] chars = (x + "").toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int length = chars.length;
        if (length % 2 == 0) {
            /*偶数*/
            leftIndex = (length >> 1) - 1;
            rightIndex = (length >> 1);
        } else {
            leftIndex = rightIndex = (length >> 1);
        }

        if (chars[leftIndex] != chars[rightIndex]) {
            return false;
        }
        while (--leftIndex >= 0 && ++rightIndex < length) {
            if (chars[leftIndex] != chars[rightIndex]) {
                return false;
            }
        }
        return true;
    }

}
