package algorithm.base;

import algorithm.ITestInterface;
import util.LogUtil;

/**
 * Created by yocn on 2019/3/20.
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * 冒泡排序
 * 原理：比较两个相邻的元素，将值大的元素交换至右端。
 * 思路：依次比较相邻的两个数，将小数放在前面，大数放在后面。即在第一趟：首先比较第1个和第2个数，将小数放前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数放前，大数放后。重复第一趟步骤，直至全部排序完成。
 * 第一趟比较完成后，最后一个数一定是数组中最大的一个数，所以第二趟比较的时候最后一个数不参与比较；
 * 第二趟比较完成后，倒数第二个数也一定是数组中第二大的数，所以第三趟比较的时候最后两个数不参与比较；
 * 依次类推，每一趟比较次数-1；
 */
public class BubbleSort implements ITestInterface {
    @Override
    public void test() {
        sort(Constants.src);
    }

    public void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = 0; j < ints.length - 1 - i; j++) {
                if (ints[j + 1] < ints[j]) {
                    int temp = ints[j + 1];
                    ints[j + 1] = ints[j];
                    ints[j] = temp;
                }
                Constants.printInts(ints);
            }
            LogUtil.Companion.d("----------");
        }
    }

}
