package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/15.
 * 一个按升序排列好的数组int[] array = {-5,-1,0,5,9,11,13,15,22,35,46},
 * 输入一个x，int x = 31，在数据中找出和为x的两个数，例如 9 + 22 = 31，要求算法的时间复杂度为O(n);
 */
public class Sum2 {
    public void test() {
        int[] array = {-5, -1, 0, 5, 9, 11, 13, 15, 22, 35, 46};
        int[] result = getSum(array, 3);
        LogUtil.Companion.d("" + result[0] + " " + result[1]);
    }

    public int[] getSum(int[] array, int target) {
        int length = array.length;
        int[] result = new int[2];
        int headIndex = 0;
        int tailIndex = length - 1;
        while (array[headIndex] + array[tailIndex] != target) {
            if (array[headIndex] + array[tailIndex] < target) {
                headIndex++;
            } else if (array[headIndex] + array[tailIndex] > target) {
                tailIndex--;
            }
            result[0] = array[headIndex];
            result[1] = array[tailIndex];
            if (headIndex >= tailIndex) {
                return result;
            }
        }
        return result;
    }
}
