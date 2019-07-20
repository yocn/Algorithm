package algorithm.other;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/18.
 */
public class HammingDistance {

    public void test() {
        int num = get2Num(2, 14);
//        LogUtil.Companion.d("result->" + get2Num(2, 14));
//        LogUtil.Companion.d("result->" + get2Num(4, 14));
//        LogUtil.Companion.d("result->" + get2Num(2, 4));
        int[] src = new int[10000];
        for (int i = 0; i < src.length; i++) {
            src[i] = i;
        }
        int result = get(src);
        LogUtil.Companion.d(result);
    }

    private int get(int[] src) {
        int result = 0;
        for (int i = 0; i < src.length; i++) {
            for (int j = i + 1; j < src.length; j++) {
                result += get2Num(src[i], src[j]);
//                LogUtil.Companion.d(src[i] + "" + src[j]);
            }
        }
        return result;
    }

    //获取两个数的二进制中位数不一致的个数
    public int get2Num(int num1, int num2) {
        int orResult = num1 ^ num2;//有几个1就有几个相同的
//        LogUtil.Companion.d(" orResult->" + Integer.toBinaryString(orResult) + " " + Integer.toBinaryString(num1) + " " + Integer.toBinaryString(num2));
        int max = num1 > num2 ? num1 : num2;
        int digit = getMaxDigit(max);
//        LogUtil.Companion.d("max->" + max + " di->" + digit + " orResult->" + Integer.toBinaryString(orResult) + " " + Integer.toBinaryString(num1) + " " + Integer.toBinaryString(num2));
        int result = 0;
        for (int i = digit; i >= 0; i--) {
            int temp = (int) Math.pow(2, i);
            if ((temp & orResult) == temp) {
                result++;
            }
        }
        return result;
    }

    //获取最大位数比如1010得到10000
    private int getMaxDigit(int num) {
        int min = 0;
        int max = 30;
        int middle = (max + min) / 2;
        while (min < max) {
            middle = (max + min) / 2;
            if (Math.pow(2, middle) >= num) {
                max = middle;
                if (Math.pow(2, middle - 1) <= num) {
                    return max;
                }
            } else {
                min = middle;
            }
        }
        return middle;
    }
}
