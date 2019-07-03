package testJava;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/3.
 */
public class testBasic {
    private static final int HASH_INCREMENT = 0x61c88647;

    public void test() {
        //        LogUtil.Companion.d("" + Integer.toBinaryString(-10));
//        LogUtil.Companion.d("" + Integer.toBinaryString(-10 & 15));
//        LogUtil.Companion.d("" + Integer.toBinaryString(-10 % 16));
        LogUtil.Companion.d("" + (-10 & 15));
        LogUtil.Companion.d("" + (-10 % 16));
        LogUtil.Companion.d("" + (10 & 15));
        LogUtil.Companion.d("" + (10 % 16));
//        LogUtil.Companion.d("" + Integer.toHexString(8));
        int x = HASH_INCREMENT;
        for (int i = 0; i <= 16; i++) {
            LogUtil.Companion.d(i + "   " + (x & 15) + " -- " + Integer.toBinaryString(x & 15) + " -- " + Integer.toBinaryString(x));
            x += HASH_INCREMENT;
        }
    }
}
