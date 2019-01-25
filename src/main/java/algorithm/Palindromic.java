package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/1/25.
 * 最长回文数
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 * <p>
 * 0 1 2 3 4 5
 * b b b b b b
 */
public class Palindromic {
    public static void test() {
        String s = longestPalindrome("cbbd");
        LogUtil.Companion.d(s);
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String result = "";
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            LogUtil.Companion.d("");
            String temp = getPanlindromic2(i, chars);
            if (temp.length() > result.length()) {
                result = temp;
            }
            LogUtil.Companion.d(i + "-" + chars[i] + "->" + temp);
        }
        return result;
    }

    private static String getPanlindromic2(int index, char[] chars) {
        String result = getPan(index - 1, index, chars);
        String result2 = getPan(index, index, chars);
        LogUtil.Companion.d("result1->" + result + " result2->" + result2);
        return result.length() > result2.length() ? result : result2;
    }

    private static String getPan(int leftIndex, int rightIndex, char[] chars) {
        if (chars[leftIndex] != chars[rightIndex]) {
            return String.copyValueOf(chars, leftIndex, 1);
        }
        int length = chars.length;
        String result = String.copyValueOf(chars, leftIndex, rightIndex - leftIndex + 1);

        while (--leftIndex >= 0 && ++rightIndex < length) {
            if (chars[leftIndex] == chars[rightIndex]) {
                result = String.copyValueOf(chars, leftIndex, rightIndex - leftIndex + 1);
            } else {
                return result;
            }
        }
        return result;
    }
}
