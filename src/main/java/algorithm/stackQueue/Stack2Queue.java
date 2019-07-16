package algorithm.stackQueue;

import util.LogUtil;

import java.util.Stack;

/**
 * Created by yocn on 2019/7/16.
 * 两个栈实现一个队列
 */
public class Stack2Queue {
    private Stack<Integer> in = new Stack<>(), out = new Stack<>();

    public void test() {
        Stack2Queue queue = new Stack2Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        LogUtil.Companion.d(queue.pop());
        queue.add(4);
        LogUtil.Companion.d(queue.pop());
        queue.add(5);
        LogUtil.Companion.d(queue.pop());
        LogUtil.Companion.d(queue.pop());
        LogUtil.Companion.d(queue.pop());
        LogUtil.Companion.d(queue.pop());
    }

    public void add(int tar) {
        in.add(tar);
    }

    private int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.empty() ? 0 : out.pop();
    }
}
