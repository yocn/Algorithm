package algorithm.backtracing;

import util.LogUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yocn on 2019/2/27.
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {
    public void test() {
        List<List<Integer>> list = permute(new int[]{1, 2, 3});
        LogUtil.Companion.d(list.toString());
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> src = new ArrayList<>();
        for (int i : nums) {
            src.add(i);
        }
        List<List<Integer>> result = new LinkedList<>();
        per(result, src, new ArrayList<>());
        return result;
    }

    private void per(List<List<Integer>> result, List<Integer> restList, List<Integer> temp) {
        if (restList.size() == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < restList.size(); i++) {
            int curr = restList.get(i);
            temp.add(curr);
            ArrayList<Integer> restTemp = new ArrayList<>(restList.subList(0, i));
            if (i + 1 <= restList.size()) {
                restTemp.addAll(restList.subList(i + 1, restList.size()));
            }
            per(result, restTemp, temp);
            temp.remove(new Integer(curr));
        }
    }
}
