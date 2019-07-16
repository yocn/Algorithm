package algorithm.base.sort;

import algorithm.ITestInterface;
import algorithm.base.Constants;
import util.LogUtil;

/**
 * Created by yocn on 2019/3/20.
 * 快速排序
 * https://mp.weixin.qq.com/s?__biz=MzIxMjE5MTE1Nw==&mid=2653195042&idx=1&sn=2b0915cd2298be9f2163cc90a3d464da&chksm=8c99f9f8bbee70eef627d0f5e5b80a604221abb3a1b5617b397fa178582dcb063c9fb6f904b3&scene=21#wechat_redirect
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 */
public class QuickSort implements ITestInterface {
    @Override
    public void test() {
        int[] sort = {4, 6, 1, 3, 2, 7, 9, 5};
        topKort(sort, 0, sort.length - 1, 6);
//        quickSort(sort, 0, sort.length - 1);
//        quickSort(Constants.src, 0, Constants.src.length - 1);
    }

    //返回topK
    private void topKort(int src[], int left, int right, int k) {
        if (k == src.length) {
            return;
        }
        if (left == right) {
            int[] result = new int[k];
            System.arraycopy(src, 0, result, 0, k);
            LogUtil.Companion.d("index221112->" + " " + left + "/" + right);
            Constants.printInts(result);
            return;
        }
        int index = sortBig(src, left, right);
        LogUtil.Companion.d("index->" + index + " " + left + "/" + right);
        if (index > k - 1) {
            topKort(src, left, index - 1, k);
        } else if (index < k - 1) {
            topKort(src, index + 1, right, k);
        } else {
            int[] result = new int[k];
            System.arraycopy(src, 0, result, 0, k);
            LogUtil.Companion.d("index222->" + index + " " + left + "/" + right);
            Constants.printInts(result);
        }
    }

    //从大到小排序
    private int sortBig(int[] src, int left, int right) {
        int pivotIndex = left;
        int pivot = src[pivotIndex];
        left++;
        while (left < right) {
            if (src[right] > pivot) {
                if (src[left] < pivot) {
                    swap(src, left, right);
                } else {
                    left++;
                }
            } else {
                right--;
            }
        }
        swap(src, pivotIndex, left);
        Constants.printInts(src);
        return left;
    }

    //快排
    public void quickSort(int[] src, int i, int j) {
        if (i >= j) {
            Constants.printInts(src, 0);
            return;
        }
        int index = sort2(src, i, j);
        quickSort(src, i, index - 1);
        quickSort(src, index + 1, j);
    }

    public int sort2(int[] src, int left, int right) {
        int pivotIndex = left;
        int pivot = src[pivotIndex];
        left++;
        while (left < right) {
            if (src[right] < pivot) {
                if (src[left] > pivot) {
                    swap(src, left, right);
                } else {
                    left++;
                }
            } else {
                right--;
            }
        }
        swap(src, pivotIndex, left);
        return left;
    }

    private void quickSort1(int[] src, int left, int right) {
        if (left == right) return;
        int index = sort1(src, left, right);
        quickSort1(src, left, index - 1);
        quickSort1(src, index + 1, right);
    }

    private int sort1(int[] src, int start, int end) {
        int left = start;
        int right = end;
        int pivot = start;
        while (left < right) {
            if (src[right] < src[pivot]) {
                if (src[left] > src[pivot]) {
                    swap(src, left, right);
                } else {
                    left++;
                }
            } else {
                right--;
            }
        }
        swap(src, pivot, left);
        Constants.printInts(src, left);
        return left;
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
     *
     * @param array 需要sort的array
     * @param left  左指针
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
