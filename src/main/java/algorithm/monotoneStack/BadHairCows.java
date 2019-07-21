package algorithm.monotoneStack;

import util.LogUtil;

import java.util.Stack;

/**
 * Created by yocn on 2019/7/20.
 * http://poj.org/problem?id=3250
 * 10，3，7，4，12，2
 */
public class BadHairCows {
    public void test() {
        int[] src = new int[]{10, 3, 7, 4, 12, 2, 1};
        int result = badHair(src);
        LogUtil.Companion.d("result->" + result);
    }

    /**
     * 10，3，7，4，12，2
     * 3 ，0，1，0， 1，0
     * 结果为5
     *
     * @param cows 数组
     * @return 结果
     */
    private int badHair(int[] cows) {
        Stack<Integer> minIndexStack = new Stack<>();
        int result = 0;
        for (int i = cows.length - 1; i >= 0; i--) {
            while (!minIndexStack.isEmpty() && cows[i] > cows[minIndexStack.peek()]) {
                //当前元素大于栈顶元素，栈顶元素比自己小需要弹出顶部元素
                minIndexStack.pop();
            }
            int bigNumIndex;
            if (minIndexStack.isEmpty()) {
                bigNumIndex = cows.length;
            } else {
                bigNumIndex = minIndexStack.peek();
            }
            minIndexStack.push(i);
            int current = bigNumIndex - i - 1;
            result += current;
        }
        return result;
    }
}
