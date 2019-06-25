package testJava;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/25.
 * 静态内部类的单例
 */
public class SingleInstance {
    static {
        LogUtil.Companion.d("SingleInstance static");
    }

    private SingleInstance() {
    }

    private static class Holder {
        private static SingleInstance mInstance = new SingleInstance();

        static {
            LogUtil.Companion.d("Holder static");
        }
    }

    public static SingleInstance getInstance() {
        return Holder.mInstance;
    }

    public static void get() {
    }
}
