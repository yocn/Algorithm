package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/1/26.
 * 正则表达式匹配
 * <p>
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class RegularExpressionMatching {
    public static void test() {
        boolean is = isMatch("aaab", ".*ab");
        LogUtil.Companion.d("is->" + is);
    }

    public static boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        boolean result = true;
        char[] srcChars = s.toCharArray();
        char[] destChars = p.toCharArray();

        int srcLength = srcChars.length;
        int destLength = destChars.length;
        int maxLength = srcLength > destLength ? srcLength : destLength;

        if (destChars[0] == '*') {
            return false;
        }

        int srcIndex = 0;
        int destIndex = 0;
//        boolean is = isMatch("aaab", ".*ab");

        for (int i = 0; i < srcLength; i++) {
            if (destIndex >= destChars.length) {
                return false;
            }
            if (srcChars[srcIndex] == destChars[destIndex]) {
                /*当前字符相等，index正常加一*/
                destIndex++;
            } else if (srcChars[srcIndex] != destChars[destIndex]) {
                LogUtil.Companion.d("src->" + srcIndex + " dest->" + destIndex);
                /*当前字符不相等：
                1、当前字符为'.'，index正常加一
                2、下一个字符为'*'，表示0个前面字符，忽略当前char加'*'，index需要增加两个
                3、当前字符为'*'，表示前一个char，index不变
                */
                if (destChars[destIndex] == '.') {
                    destIndex++;
                } else if (destChars[destIndex] == '*') {
                    if (destChars[destIndex - 1] == '.') {

                    } else if (srcChars[srcIndex] != destChars[destIndex - 1]) {
                        result = false;
                    }
                } else if (destIndex + 1 < destLength && destChars[destIndex + 1] == '*') {
                    destIndex = srcIndex + 2;
                    if (srcChars[srcIndex] == destChars[destIndex]) {
                        destIndex++;
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
            srcIndex++;
            if (!result) {
                return result;
            }
        }
        return result;
    }
}
