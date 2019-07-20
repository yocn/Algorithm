package algorithm.monotoneStack;

import algorithm.base.Constants;

import java.util.Stack;

/**
 * Created by yocn on 2019/7/20.
 */
public class MinLeftNum {
    public void test() {
        //[]
        int[] src = new int[]{6, 8, 3, 7, 4, 9, 2};
        int[] result = getLeftMinNum(src);
        int[] result2 = getLeftMaxNum(src);
        Constants.printInts(src,"");
        Constants.printInts(result,"");
        Constants.printInts(result2,"");
    }

    //获取左边第一个小于自己的数，构造一个单调递增栈
    private int[] getLeftMinNum(int[] src) {
        int[] result = new int[src.length];
        Stack<Integer> monotoneStack = new Stack<>();
        for (int i = 0; i < src.length; i++) {
            if (monotoneStack.isEmpty()) {
                monotoneStack.push(src[i]);
                result[i] = 0;
            } else {
                while (!monotoneStack.isEmpty() && src[i] < monotoneStack.peek()) {
                    monotoneStack.pop();
                }
                if (!monotoneStack.isEmpty()) {
                    result[i] = monotoneStack.peek();
                } else {
                    result[i] = -1;
                }
                monotoneStack.push(src[i]);
            }
        }
        return result;
    }

    //获取左边第一个小于自己的数，构造一个单调递增栈
    private int[] getLeftMaxNum(int[] src) {
        int[] result = new int[src.length];
        Stack<Integer> monotoneStack = new Stack<>();
        for (int i = 0; i < src.length; i++) {
            if (monotoneStack.isEmpty()) {
                monotoneStack.push(src[i]);
                result[i] = 0;
            } else {
                while (!monotoneStack.isEmpty() && src[i] > monotoneStack.peek()) {
                    monotoneStack.pop();
                }
                if (!monotoneStack.isEmpty()) {
                    result[i] = monotoneStack.peek();
                } else {
                    result[i] = -1;
                }
                monotoneStack.push(src[i]);
            }
        }
        return result;
    }
}
