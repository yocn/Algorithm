package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/3/7.
 * Pascal's Triangle
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * <p>
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public void test() {
        List<List<Integer>> list = generate(11);
        LogUtil.Companion.d("list->" + list.toString());
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        int num = 0;

        for (int i = 0; i < numRows; i++) {
            num++;
            List<Integer> list = new ArrayList<>();
            if (i == 0) {
                list.add(1);
                result.add(list);
                continue;
            } else if (i == 1) {
                list.add(1);
                list.add(1);
                result.add(list);
                continue;
            }

            List<Integer> lastList = result.get(result.size() - 1);
            for (int j = 0; j < num; j++) {
                int pre = (j - 1 >= 0) ? lastList.get(j - 1) : 0;
                int current = (j < lastList.size()) ? lastList.get(j) : 0;
                list.add(pre + current);
            }
            result.add(list);
            LogUtil.Companion.d("i->" + i + " lastList->" + lastList.toString());
        }
        return result;
    }
}
