package algorithm.base.sort;

import algorithm.ITestInterface;
import algorithm.base.Constants;
import util.LogUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yocn on 2019/3/20.
 * 计数排序
 */
public class CountingSort implements ITestInterface {
    @Override
    public void test() {
        countingSort(Constants.src2);
    }

    public int[] countingSort(int[] array) {
        int[] result = new int[array.length];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int repeat = map.getOrDefault(array[i], 0);
            map.put(array[i], ++repeat);
        }
        for (int key : map.keySet()) {
            int value = map.get(key);
            LogUtil.Companion.d("key->" + key + " value->" + value);
            while (value != 0) {
                value--;
                result[index] = key;
                index++;
            }
        }
        Constants.printInts(result);
        return result;
    }
}
