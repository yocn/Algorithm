package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yocn on 2019/1/29.
 */
public class SimpleDyncProxy {
    public void test(){
        create(SimpleInterface.class).simple();
    }

    interface SimpleInterface {
        void simple();
    }

    public SimpleInterface create(Class<SimpleInterface> simpleInterface) {
        return (SimpleInterface) Proxy.newProxyInstance(simpleInterface.getClassLoader(), new Class[]{simpleInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                method.invoke(simpleInterface, args);
                return null;
            }
        });
    }
}
