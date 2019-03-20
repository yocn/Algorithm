package algorithm.base.sort;

import algorithm.ITestInterface;
import algorithm.base.Constants;

/**
 * Created by yocn on 2019/3/20.
 * 选择排序
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
 * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort implements ITestInterface {
    @Override
    public void test() {
        SelectionSort(Constants.src);
    }

    public void SelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index = i;
            int min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
            Constants.printInts(array);
        }
    }
}
