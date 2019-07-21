package algorithm.monotoneStack;

import util.LogUtil;

import java.util.Stack;

/**
 * Created by yocn on 2019/7/20.
 */
public class StageWater {
    public void test() {
        int src[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(src);
        LogUtil.Companion.d("result->" + result);
    }

    private int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int sumArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int right = 0; right < height.length; right++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[right]) {
                if (stack.size() >= 2) {
                    int j = stack.pop();
                    int left = stack.peek();
                    int waterHeight = Math.min(height[right], height[left]) - height[j];//就像一个木桶：得到最低的木板减去底得到能装水的高度
                    int waterLength = right - left - 1;
                    int curArea = waterHeight * waterLength;
                    sumArea += curArea;
                } else {
                    stack.pop();
                }
            }
            stack.push(right);
        }
        return sumArea;
    }

    private String printStack(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }

    private String printStack(int[] src, Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        for (int i : stack) {
            sb.append(src[i]).append(" ");
        }
        return sb.toString();
    }
}
