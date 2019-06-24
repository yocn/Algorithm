package algorithm.base.sort;

import algorithm.ITestInterface;
import algorithm.base.Constants;

/**
 * Created by yocn on 2019/3/20.
 * 快速排序
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195042&idx=1&sn=2b0915cd2298be9f2163cc90a3d464da&chksm=8c99f9f8bbee70eef627d0f5e5b80a604221abb3a1b5617b397fa178582dcb063c9fb6f904b3&scene=21#wechat_redirect
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort implements ITestInterface {
    @Override
    public void test() {
        int[] sort = {4, 7, 6, 5, 3, 2, 8, 1};
//        quitSort(sort, 0, sort.length - 1);
        quitSort(Constants.src, 0, Constants.src.length - 1);
    }

    public void quitSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = sort(array, left, right);
        quitSort(array, left, index - 1);
        quitSort(array, index + 1, right);
    }

    /**
     * 一遍遍历sort
     * @param array 需要sort的array
     * @param left 左指针
     * @param right 右指针
     * @return pivot的index
     */
    public int sort(int[] array, int left, int right) {
        int pivotIndex = left;
        int pivot = array[pivotIndex];
        int leftIndex = left;
        int rightIndex = right;
        while (rightIndex != leftIndex) {
            if (array[rightIndex] < pivot) {
                //右指针比基准小，等待左指针找到比基准大的交换
                if (array[leftIndex] > pivot) {
                    swap(array, leftIndex, rightIndex);
                } else {
                    leftIndex++;
                }
            } else {
                //右指针比基准大，右指针左移
                rightIndex--;
            }
        }
        swap(array, leftIndex, pivotIndex);
        Constants.printInts(array, leftIndex);
        return leftIndex;
    }

    private void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
