package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/8.
 * x个苹果，一天只能吃一个、两个、或者三个，问多少天可以吃完
 */
public class XApple {
    public void test() {
        eatApple(5, 0, "");
    }

    private void eatApple(int x, int day, String result) {
        eatAppleEveryDay(x, 1, day, result);
        eatAppleEveryDay(x, 2, day, result);
        eatAppleEveryDay(x, 3, day, result);
    }

    /**
     * @param left     还剩苹果个数
     * @param everyDay 每天吃的个数
     * @param day      无意义，打印用，第几天
     * @param result   无意义，打印用，结果传递
     */
    private void eatAppleEveryDay(int left, int everyDay, int day, String result) {
        result = result + day + " " + everyDay + "|";
        left -= everyDay;

        if (left < 0) {
            return;
        }
        if (left == 0) {
            LogUtil.Companion.d(result);
            return;
        }
        eatApple(left, ++day, result);
    }
}
