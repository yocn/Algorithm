package testJava;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/3.
 */
public class testAnonymityInnerClass {
    static {
        LogUtil.Companion.d("testAnonymityInnerClass加载");
    }
    {
        LogUtil.Companion.d("testAnonymityInnerClass 代码块");
    }

    public void test() {
        InnerA innerA = new InnerA() {
            @Override
            public void InnerAmethodA() {
                LogUtil.Companion.d("InnerAmethodA");
            }
        };
        innerA.InnerAmethodA();
        StaticInnerA staticInnerA = new StaticInnerA() {

            @Override
            public void staticInnerAmethodA() {
                LogUtil.Companion.d("staticInnerAmethodA");
            }
        };
        staticInnerA.staticInnerAmethodA();

//        ClassLoader classLoader = getClass().getClassLoader();
    }

    public class InnerA {
        {
            LogUtil.Companion.d("InnerA 代码块");
        }

        public void InnerAmethodA() {
            LogUtil.Companion.d("Class InnerAmethodA");
        }
    }

    public static class StaticInnerA {
        static {
            LogUtil.Companion.d("StaticInnerA 加载");
        }

        public void staticInnerAmethodA() {
            LogUtil.Companion.d("Class staticInnerAmethodA");
        }

    }
}
