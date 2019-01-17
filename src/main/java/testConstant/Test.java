package testConstant;

import util.LogUtil;

/**
 * Created by yocn on 2018/12/16.
 */
public class Test {

    static {
        LogUtil.Companion.d("yocn static Test");
    }

    public static class inner {
        public static int i = 0;

        static {
            LogUtil.Companion.d("yocn inner static Test");
        }
    }
}
