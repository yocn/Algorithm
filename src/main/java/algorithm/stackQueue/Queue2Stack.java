package algorithm.stackQueue;

import util.LogUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yocn on 2019/7/16.
 * 两个队列实现一个栈
 */
public class Queue2Stack {
    private Queue<Integer> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
    private int current = 0;

    public void test() {
        Queue2Stack stack = new Queue2Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        LogUtil.Companion.d("q1->" + stack.q1.size());
        LogUtil.Companion.d("poll1->" + stack.poll() + " current->" + stack.current + " q1->" + stack.q1.toString() + " q2->" + stack.q2.toString());
        LogUtil.Companion.d("poll2->" + stack.poll() + " current->" + stack.current + " q1->" + stack.q1.toString() + " q2->" + stack.q2.toString());
        LogUtil.Companion.d("poll3->" + stack.poll() + " current->" + stack.current + " q1->" + stack.q1.toString() + " q2->" + stack.q2.toString());
    }

    public void add(Integer i) {
        Queue<Integer> queue = current == 0 ? q1 : q2;
        queue.add(i);
    }

    private int poll() {
        Queue<Integer> src = current == 0 ? q1 : q2, target = current == 0 ? q2 : q1;
        if (src.isEmpty()) {
            return 0;
        }
        int index = 0, result = 0, size = src.size();
        while (src.peek() != null) {
            index++;
            result = src.poll();
            if (index < size) {
                target.add(result);
            }
        }
        current = current == 0 ? 1 : 0;
        return result;
    }
}
