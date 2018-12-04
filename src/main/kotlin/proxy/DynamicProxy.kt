package proxy

import util.LogUtil
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

/**
 * Created by yocn on 2018/11/29.
 */
class DynamicProxy(proxyReal: Any) : InvocationHandler {
    var proxyImpl = proxyReal
    override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any {
        if (args == null) {
            LogUtil.d("yocn args1-" + args?.size)
            method.invoke(proxyImpl)
        } else {
            LogUtil.d("yocn args2-" + args.size)
            method.invoke(proxyImpl, *args)
        }
        return Any()
    }
}