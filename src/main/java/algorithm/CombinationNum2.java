package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 思路：
 */
public class CombinationNum2 {
    public void test() {
        List<List<Integer>> result = combinationSum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        LogUtil.Companion.d(result.toString());
    }

    private int mTarget;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        mTarget = target;
        List<Integer> src = new ArrayList<>();
        for (int candidate : candidates) {
            src.add(candidate);
        }
        src.sort((o1, o2) -> o1 - o2);
        getCombination(src, new ArrayList<>(), 0, 0, 0);
        LogUtil.Companion.d(src.toString());
        return result;
    }

    private void getCombination(List<Integer> remainingList, List<Integer> temp, int level, int pre, int layer) {
        if (getListSum(temp) == mTarget) {
            result.add(temp);
            return;
        }
        layer++;
        for (int i = level; i < remainingList.size(); i++) {
            int current = remainingList.get(i);
            LogUtil.Companion.d("layer->" + layer);
            if (current == pre) {

            } else {
                pre = current;
                List<Integer> list = getRestList(remainingList, i);
                List<Integer> tempResult = new ArrayList<>();
                tempResult.addAll(temp);
                tempResult.add(current);
                getCombination(list, tempResult, i, current, layer);
            }
        }

    }

    private List<Integer> getRestList(List<Integer> srcList, int index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < srcList.size(); i++) {
            if (index != i) {
                list.add(srcList.get(i));
            }
        }
        return list;
    }

    private int getListSum(List<Integer> temp) {
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum;
    }
}
