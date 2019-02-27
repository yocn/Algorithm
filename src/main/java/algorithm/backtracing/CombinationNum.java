package algorithm.backtracing;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/2/26.
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * 思路：回溯算法->判断条件是是否小于target  如果是小于target继续加，大于target回溯或者结束，先排序比较好~
 */
public class CombinationNum {
    public void test() {
        List<List<Integer>> result = combinationSum(new int[]{2, 3, 6, 7}, 7);
        LogUtil.Companion.d(result.toString());
    }

    private int mTarget;
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        mTarget = target;
        getCombination(candidates, new ArrayList<>(), 0);
        return result;
    }

    private void getCombination(int[] candidates, List<Integer> temp, int level) {
        if (getListSum(temp) > mTarget) {
            return;
        }
        if (getListSum(temp) == mTarget) {
            result.add(temp);
            LogUtil.Companion.d("temp->" + temp.toString());
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.addAll(temp);
            if (candidates[i] <= mTarget) {
                list.add(candidates[i]);
                LogUtil.Companion.d(level + "  candidate->" + candidates[i]);
                getCombination(candidates, list, i);
            }
        }
    }

    private int getListSum(List<Integer> temp) {
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum;
    }
}
