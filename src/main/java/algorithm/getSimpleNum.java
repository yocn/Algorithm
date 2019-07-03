package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/2.
 */
public class getSimpleNum {

    public static void test() {
        int[] nums = new int[]{1, 2, 3, 5, 3, 2, 1};
        int single = getSingle(nums);
        LogUtil.Companion.d("" + single);
    }

    public static int getSingle(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
