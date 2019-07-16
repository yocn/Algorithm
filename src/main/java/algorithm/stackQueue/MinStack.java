package algorithm.stackQueue;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/7/15.
 * 实现一个栈，可以随时得到最小数
 */
public class MinStack {
    private List<Integer> data = new ArrayList<Integer>();
    private List<Integer> min = new ArrayList<Integer>();

    public void test() {
        MinStack stack = new MinStack();
        stack.add(3);
        stack.add(1);
        stack.add(5);
        stack.add(9);
        LogUtil.Companion.d(stack.min() + "");
        stack.pop();
        LogUtil.Companion.d(stack.min() + "");
        stack.pop();
        LogUtil.Companion.d(stack.min() + "");
        stack.pop();
        LogUtil.Companion.d(stack.min() + "");
        stack.pop();
        LogUtil.Companion.d(stack.min() + "");
        stack.pop();
        LogUtil.Companion.d(stack.min() + "");
    }

    public void add(int num) {
        data.add(0, num);
        if (min.isEmpty()) {
            min.add(num);
        } else {
            min.add(0, (num > min.get(0) ? min.get(0) : num));
        }
    }

    private int pop() {
        if (data.isEmpty()) {
            return -1;
        }
        int i = data.get(0);
        data.remove(0);
        min.remove(0);
        return i;
    }

    private int min() {
        if (data.isEmpty()) {
            return -1;
        }
        return min.get(0);
    }
}
