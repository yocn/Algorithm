package algorithm.base;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/20.
 * 二分查找
 */
public class BinarySearch {
    public void test() {
        int x = find(init(107), 4);
        LogUtil.Companion.d("index->" + x);
    }

    public int find(int[] ints, int target) {
        int low, high, middle = 0;
        low = ints[0];
        high = ints[ints.length - 1];
        middle = (low + high) / 2;
        while (ints[middle] != target) {
            if (middle < target) {
                low = ints[middle];
            } else {
                high = ints[middle];
            }
            middle = (low + high) / 2;
            LogUtil.Companion.d("low->" + low + " hi->" + high + " middle");
        }
        return middle;
    }

    public int[] init(int x) {
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = i;
        }
        return array;
    }
}
