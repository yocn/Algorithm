package algorithm.backtracing;

import util.LogUtil;

import java.util.*;

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
        long time1 = System.currentTimeMillis();
//        List<List<Integer>> result1 = combinationSum(
//                new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33,
//                        20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12},
//                27);
        List<List<Integer>> result = combinationSum(
                new int[]{10, 1, 2, 7, 6, 1, 5},
                8);
        long time2 = System.currentTimeMillis();
        LogUtil.Companion.d((time2 - time1) + " - " + result.toString());
    }

    private int mTarget;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        mTarget = target;
        List<Integer> src = new LinkedList<>();
        Arrays.sort(candidates);
        for (int candidate : candidates) {
            src.add(candidate);
        }
        getCombination(src, new LinkedList<>(), 0, 0, 0);
        LogUtil.Companion.d(src.toString());
        return result;
    }

    private void getCombination(List<Integer> remainingList, List<Integer> temp, int level, int layer, int currentSum) {
        if (currentSum == mTarget) {
            result.add(new LinkedList<>(temp));
            return;
        }
        layer++;
        for (int i = level; i < remainingList.size(); i++) {
            if (i > level && remainingList.get(i) == remainingList.get(i - 1)) {
//                LogUtil.Companion.d("layer->" + layer + " current->" + remainingList.get(i) + " pre->" + remainingList.get(i - 1));
                continue;
            }
//            List<Integer> list = getRestList(remainingList, i);

            int current = remainingList.get(i);
            temp.add(current);
            currentSum += current;
            remainingList.remove(new Integer(current));
            getCombination(remainingList, temp, i, layer, currentSum);
            remainingList.add(new Integer(current));
            currentSum -= current;
            temp.remove(new Integer(current));
        }
    }

    private List<Integer> getRestList(List<Integer> srcList, int index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < srcList.size(); i++) {
            if (index != i) {
                list.add(srcList.get(i));
            }
        }
        return list;
    }

}
