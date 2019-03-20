package algorithm.base.sort;

import algorithm.ITestInterface;
import algorithm.base.Constants;
import testConstant.Constant;

/**
 * Created by yocn on 2019/3/20.
 * 插入排序
 * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
 */
public class InsertionSort implements ITestInterface {
    @Override
    public void test() {
        sort(Constants.src);
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = i; j > 0; j--) {
                if (array[i] > array[j]) {

                }
            }
        }
    }
}
