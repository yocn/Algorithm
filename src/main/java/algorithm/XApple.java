package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/8.
 * x个苹果，一天只能吃一个、两个、或者三个，问多少天可以吃完
 * 说实话我拿到这问题第一时间只是把eatApple写了出来，但是没想明白问什么，这个时候我就把BinaryTree的深度优先遍历写了一下，发现其实是一样的，就是重复调用自己。
 * 那是不是说这个题目也可以同样的用二叉树的结构表现出来呢？
 * 是的，只要用DFS遍历这棵三叉树就可以了，路径加起来为x就是了。
 */
public class XApple {
    private static int num = 0;

    public void test() {
        eatApple(7, 0, "");
        LogUtil.Companion.d(num);
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
        result = result + "第" + day + "天吃" + everyDay + "个|";
        left -= everyDay;
        num++;
        if (left < 0) {
            return;
        }
        if (left == 0) {
            System.out.print(result + "\n");
            return;
        }
        eatApple(left, ++day, result);
    }

    private void eatApple(int x) {
        eatAppleEveryDay(x, 1);
        eatAppleEveryDay(x, 2);
        eatAppleEveryDay(x, 3);
    }

    private void eatAppleEveryDay(int left, int everyDay) {
        left -= everyDay;
        if (left <= 0) {
            return;
        }
        eatApple(left);
    }
}
