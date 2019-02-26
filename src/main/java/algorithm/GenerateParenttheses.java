package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class GenerateParenttheses {
    public void test() {
        int n = 2;
        int leftnum = n, rightnum = n;//左括号和右括号都各有n个
        ArrayList<String> results = new ArrayList<String>();//用于存放解空间
        parentheses("", results, leftnum, rightnum);
//        for (String s : results)
//            System.out.println(s);
    }

    public static void parentheses(String sublist, ArrayList<String> results, int leftnum, int rightnum) {
        LogUtil.Companion.d(leftnum + "/" + rightnum + " -> " + sublist + "          -" + results.toString());
        if (leftnum == 0 && rightnum == 0) {
            results.add(sublist);
        }
        if (rightnum > leftnum) {
            //选择和条件。对于不同的if顺序，输出的结果顺序是不一样的，但是构成一样的解空间
            LogUtil.Companion.d("a");
            parentheses(sublist + ")", results, leftnum, rightnum - 1);
        }
        if (leftnum > 0) {
            LogUtil.Companion.d("b");
            parentheses(sublist + "(", results, leftnum - 1, rightnum);
        }
    }
}
