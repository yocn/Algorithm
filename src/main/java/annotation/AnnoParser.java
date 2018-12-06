package annotation;

import util.LogUtil;

import java.lang.reflect.Method;

/**
 * Created by yocn on 2018/12/4.
 */
public class AnnoParser {
    public void parse(Class clazz) {

        Method[] delMethod = clazz.getDeclaredMethods();
        for (Method method : delMethod) {

//            method.getAnnotations()

            if (method.isAnnotationPresent(Fancy.class)) {
                String returnType = method.getGenericReturnType().getTypeName();
                Fancy fancy = method.getAnnotation(Fancy.class);
                LogUtil.Companion.d("fancy->" + fancy.msg() + " return->" + returnType);
            }
        }
    }
}
