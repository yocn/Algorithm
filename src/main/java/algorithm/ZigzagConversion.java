package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/1/25.
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ZigzagConversion {
    public static void test() {
        String result = convert("PAYPALISHIRING", 4);
        LogUtil.Companion.d("result->" + result);
    }

    public static String convert(String s, int numRows) {
        if ("".equals(s)) {
            return "";
        }
        if (numRows == 0 || numRows == 1) {
            return s;
        }
        char[] totalChars = s.toCharArray();
        int length = totalChars.length;
        /*每列加后面的弯弯算做一个chunk，一个chunk包含chunkNums个char*/
        int chunkNums = numRows * 2 - 2;
        /*一共有多少个chunk*/
        int chunks = length / chunkNums + 1;
        LogUtil.Companion.d("l->" + length + " num->" + chunkNums + " chunks->" + chunks);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            if (j == 0) {
                /*第一种情况：*/
                for (int i = 0; i < chunks; i++) {
                    int index = i * chunkNums;
                    if (index < length) {
                        sb.append(totalChars[index]);
                    }
                }
            } else if (j == numRows - 1) {
                /*这两种情况只有一个*/
                for (int i = 0; i < chunks; i++) {
                    int index = i * chunkNums + (numRows - 1);
                    if (index < length) {
                        sb.append(totalChars[index]);
                    }
                }
            } else {
                /*否则有两个*/
                for (int i = 0; i < chunks; i++) {
                    int firstIndex = i * chunkNums + j;
                    int secondIndex = i * chunkNums + (chunkNums - j);
                    if (firstIndex < length) {
                        sb.append(totalChars[firstIndex]);
                    }
                    if (secondIndex < length) {
                        sb.append(totalChars[secondIndex]);
                    }
                }
            }

        }
        return sb.toString();
    }

}















