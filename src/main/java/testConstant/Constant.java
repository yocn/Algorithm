package testConstant;

import util.LogUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by yocn on 2018/12/16.
 */
public class Constant {
    private static class BaseConstant {
        protected static int[] mConstantScope;
    }

    public static class Function extends BaseConstant {
        public static final int TYPE_TOAST = 200;
        public static final int TYPE_SHOW_LOCAL_IMAGE = 201;
    }

    public static boolean ifInConstents(Class clazz, int key) {
        try {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.getType().toString().contains("int")
                        && Modifier.isStatic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers())) {
                    if (key == (int) field.get(clazz)) {
                        return true;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

}
