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
        low = 0;
        high = ints.length - 1;
        middle = (low + high) / 2;
        while (ints[middle] != target) {
            if (ints[middle] < target) {
                low = ints[middle];
            } else if (ints[middle] > target) {
                high = ints[middle];
            } else {
                return middle;
            }
            middle = (low + high) / 2;
            LogUtil.Companion.d("low->" + low + " hi->" + high + " middle");
        }
        return middle;
    }

    public int[] init(int x) {
        int[] array = new int[x];
        for (int i = 0; i < x; i++) {
            array[i] = i - 2;
        }
        return array;
    }

    public int binSearch(int[] src, int target) {
        int low = 0, high, middle = 0;
        high = src.length - 1;
        middle = (low + high) / 2;
        while (low < high) {
            if (src[middle] < target) {
                low = middle + 1;
            } else if (src[middle] > target) {
                high = middle - 1;
            } else {
                return middle;
            }
            middle = (low + high) / 2;
        }
        return -1;
    }

}
