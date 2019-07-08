package testJava;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/3.
 */
public class testAnonymityInnerClass {

    public void test() {
        InnerA innerA = new InnerA() {
            @Override
            public void InnerAmethodA() {
                LogUtil.Companion.d("匿名内部类InnerAmethodA");
            }
        };
//        innerA.InnerAmethodA();
        StaticInnerA staticInnerA = new StaticInnerA() {

            @Override
            public void staticInnerAmethodA() {
                LogUtil.Companion.d("staticInnerAmethodA");
            }
        };
//        staticInnerA.staticInnerAmethodA();
    }

    public testAnonymityInnerClass() {
        LogUtil.Companion.d("构造方法");
    }

    static {
        LogUtil.Companion.d("静态代码块 testAnonymityInnerClass加载");
    }

    {
        LogUtil.Companion.d("代码块 testAnonymityInnerClass 代码块");
    }

    public class InnerA {
        {
            LogUtil.Companion.d("内部类 InnerA 代码块");
        }

        public void InnerAmethodA() {
            LogUtil.Companion.d("Class InnerAmethodA");
        }
    }

    public static class StaticInnerA {
        static {
            LogUtil.Companion.d("静态内部类 加载 静态代码块");
        }

        public void staticInnerAmethodA() {
            LogUtil.Companion.d("Class staticInnerAmethodA");
        }

    }
}
