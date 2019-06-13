package reflect;

import util.LogUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yocn on 2019/6/5.
 */
public class testReflect {
    class Parent {
        private int i = 10;

        public int get() {
            return 10;
        }
    }

    class Children extends Parent {
        private int i = 20;

        public int get() {
            return i;
        }
    }

    public void test() {
        Children children = new Children();
        Parent children1 = new Children();
        Parent children2 = new Parent();
        LogUtil.Companion.d(children.get());
        LogUtil.Companion.d(((Parent) children).get());

        LogUtil.Companion.d("super->" + Children.class.getSuperclass());
        LogUtil.Companion.d("super->" + Children.class);
        try {
            Method method = Children.class.getSuperclass().getMethod("get");
            LogUtil.Companion.d("method->" + method);
            try {
                Object oo = method.invoke(children);
                LogUtil.Companion.d("oo->" + oo.toString());
                Object oo1 = method.invoke(children1);
                LogUtil.Companion.d("oo1->" + oo1.toString());
                Object oo2 = method.invoke(children2);
                LogUtil.Companion.d("oo2->" + oo2.toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
