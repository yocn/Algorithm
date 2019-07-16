package algorithm;

/**
 * Created by yocn on 2019/7/16.
 * 获取TopK个大数
 */
public class TopK {
    private int getIndex(int[] src, int left, int right) {
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
        swap(src, left, pivotIndex);
        return left;
    }

    private int[] topK(int[] src, int left, int right, int k) {
        if (k >= src.length) {
            return src;
        }
        if (left == right) {
            int[] result = new int[k];
            System.arraycopy(src, 0, result, 0, k);
            return result;
        }
        int index = getIndex(src, left, right);
        if (index > k - 1) {
            topK(src, left, index - 1, k);
        } else if (index < k - 1) {
            topK(src, index + 1, right, k);
        } else {
            int[] result = new int[k];
            System.arraycopy(src, 0, result, 0, k);
            return result;
        }
        return new int[k];
    }

    private void swap(int src[], int left, int right) {
        int temp = src[left];
        src[left] = src[right];
        src[right] = temp;
    }
}
