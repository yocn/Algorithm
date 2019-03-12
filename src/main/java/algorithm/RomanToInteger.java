package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/12.
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 示例 1:
 * 输入: "III"
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: "IV"
 * 输出: 4
 * <p>
 * 示例 3:
 * 输入: "IX"
 * 输出: 9
 * <p>
 * 示例 4:
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 示例 5:
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {
    public void test() {
        int x = romanToInt("MDLXX");
        LogUtil.Companion.d("x->" + x);
    }

    public int romanToInt(String s) {
        int result = 0;
        int index = 0;
        boolean jump = true;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!jump) {
                jump = true;
                continue;
            }
            if (c == 'I') {
                if (index + 1 < chars.length) {
                    char right = chars[index + 1];
                    if (right == 'V') {
                        result += 4;
                        index += 2;
                        jump = false;
                        continue;
                    } else if (right == 'X') {
                        result += 9;
                        index += 2;
                        jump = false;
                        continue;
                    }
                }
                result += 1;
                index++;
            } else if (c == 'V') {
                result += 5;
                index++;
            } else if (c == 'X') {
                if (index + 1 < chars.length) {
                    char right = chars[index + 1];
                    if (right == 'L') {
                        result += 40;
                        index += 2;
                        jump = false;
                        continue;
                    } else if (right == 'C') {
                        result += 90;
                        index += 2;
                        jump = false;
                        continue;
                    }
                }
                result += 10;
                index++;
            } else if (c == 'L') {
                result += 50;
                index++;
            } else if (c == 'C') {
                if (index + 1 < chars.length) {
                    char right = chars[index + 1];
                    if (right == 'D') {
                        result += 400;
                        index += 2;
                        jump = false;
                        continue;
                    } else if (right == 'M') {
                        result += 900;
                        index += 2;
                        jump = false;
                        continue;
                    }
                }
                result += 100;
                index++;
            } else if (c == 'D') {
                result += 500;
                index++;
            } else if (c == 'M') {
                result += 1000;
                index++;
            }
        }

        return result;
    }
}