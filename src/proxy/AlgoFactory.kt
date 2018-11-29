package proxy

import java.lang.reflect.Proxy

/**
 * Created by yocn on 2018/11/29.
 */
class AlgoFactory {
    companion object {
        fun create(handler: DynamicProxy): IAlgoProxy {
            val proxy: IAlgoProxy = Proxy.newProxyInstance(handler.javaClass.classLoader, handler.proxyImpl::class.java.interfaces, handler) as IAlgoProxy
            return proxy
        }
    }
}