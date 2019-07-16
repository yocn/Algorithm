package algorithm.base.sort;

import algorithm.base.Constants;
import util.LogUtil;

/**
 * Created by yocn on 2019/7/16.
 * 归并排序
 */
public class CombineSort {
    public void test() {
        int[] src = new int[]{11, 8, 9, 3, 7, 2, 5, 4, 1};
        Constants.printInts(src);
        mergeSort(src, 0, src.length - 1);
        Constants.printInts(src);
    }

    private void combine(int[] src, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = (left + right) / 2;
        combine(src, left, middle);
        combine(src, middle + 1, right);
        sort(src, left, right, middle);
        Constants.printInts(src, "排序结束->");
    }

    private void sort(int src[], int left, int right, int middle) {
        int[] temp = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            temp[i - left] = src[i];
        }
        int current = left;
        int l = left, r = middle + 1;
        while (l <= middle || r <= right) {
            if (l > middle) {
                src[current++] = temp[r++ - left];
                continue;
            }
            if (r > right) {
                src[current++] = temp[l++ - left];
                continue;
            }
            if (temp[l - left] > temp[r - left]) {
                src[current++] = temp[r++ - left];
            } else {
                src[current++] = temp[l++ - left];
            }
        }
    }

    public void mergeSort(int[] src, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(src, start, middle);
        mergeSort(src, middle + 1, end);
        cSort(src, start, end, middle);
    }

    //归并排序
    public void cSort(int[] src, int start, int end, int middle) {
        int[] temp = new int[end + 1 - start];
        for (int i = start; i < end + 1; i++) {
            temp[i - start] = src[i];
        }
        int current = start;
        int left = start;
        int right = middle + 1;
        while (left <= middle || right <= end) {
            if (left > middle) {
                src[current++] = temp[right++ - start];
                continue;
            }
            if (right > end) {
                src[current++] = temp[left++ - start];
                continue;
            }
            if (temp[left - start] > temp[right - start]) {
                src[current++] = temp[right++ - start];
            } else {
                src[current++] = temp[left++ - start];
            }
        }
    }

}
