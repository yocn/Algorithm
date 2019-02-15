package proxy;

import util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yocn on 2019/1/29.
 * simple 动态代理
 */
public class SimpleDynamicProxy {
    public void test() {
        SimpleInterface simpleInterface = createSimple(new SimpleClass1());
        simpleInterface.doThing1();
        SimpleInterface generalInterface1 = createT(new SimpleClass1());
        generalInterface1.doThing1();
        SimpleInterface generalInterface2 = createT(new SimpleClass2());
        generalInterface2.doThing1();
        LogUtil.Companion.d("doStringThing->" + generalInterface2.doStringThing());
        LogUtil.Companion.d("doIntThing->" + generalInterface2.doIntThing());
    }

    interface SimpleInterface {
        void doThing1();

        String doStringThing();

        int doIntThing();
    }

    public class SimpleClass1 implements SimpleInterface {

        @Override
        public void doThing1() {
            LogUtil.Companion.d("SimpleClass1 doThing1");
        }

        @Override
        public String doStringThing() {
            return "SimpleClass1 doThing2";
        }

        @Override
        public int doIntThing() {
            return 1001;
        }
    }

    public class SimpleClass2 implements SimpleInterface {

        @Override
        public void doThing1() {
            LogUtil.Companion.d("SimpleClass2 doThing1");
        }

        @Override
        public String doStringThing() {
            return "SimpleClass1 doThing2";
        }

        @Override
        public int doIntThing() {
            return 1221;
        }
    }

    private SimpleInterface createSimple(SimpleInterface object) {
        /*最简单的例子，传进来一个继承了SimpleInterface的class的实例，我们拿到*/
        return (SimpleInterface) Proxy.newProxyInstance(
                //这里其实可以用谁的classLoader都行，只要是AppClassLoader就可以，可以用new SimpleClass().getClass().getClassLoader()代替
                object.getClass().getClassLoader(),
                //获取到需要代理的接口，这里可以看出来必须要有接口，没有实现接口的class是不可以动态代理的，因为没有实现接口
                object.getClass().getInterfaces(),
                //重写InvocationHandler，这是动态代理最重要的点，我们使用动态代理其实就是为了在下面做事情
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        LogUtil.Companion.d("simple dynamic proxy");
                        // 千万不可以用method.invoke(proxy, args)，自己调用自己会造成递归调用，无法退出 !!!!!!!
                        method.invoke(object, args);
                        return null;
                    }
                });
    }

    private <T> T createT(SimpleInterface object) {
        /*更加通用的实现方式，假如我有多个实现了SimpleInterface的class，那可以实现传过来什么代理成什么的实现，可以看上面的调用。
        * SimpleClass1和SimpleClass2传过来什么代理出来什么。*/
        Object o = Proxy.newProxyInstance(
                object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        LogUtil.Companion.d("dynamic dynamic proxy");
                        //返回值表示方法的返回值，String或者int或者对象或者其他...
                        return method.invoke(object, args);
                    }
                });
        return (T) o;
    }
}
