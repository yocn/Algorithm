package algorithm;

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
        LogUtil.Companion.d("" + isPalindrome(100));
    }

    public static boolean isPalindrome(int x) {
        return getPanlindromic(x);
    }

    private static boolean getPanlindromic(int x) {
        if (x < 0) {
            return false;
        }
        LogUtil.Companion.d("" + x / 10);
        return true;
    }

    private static boolean getPanlindromic2(int x) {
        char[] chars = (x + "").toCharArray();
        int leftIndex = 0;
        int rightIndex = 0;
        int length = chars.length;
        if (length % 2 == 0) {
            /*偶数*/
            leftIndex = length / 2 - 1;
            rightIndex = length / 2;
        } else {
            leftIndex = rightIndex = length / 2;
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
