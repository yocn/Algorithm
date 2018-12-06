package proxy

import util.LogUtil
import java.lang.reflect.Proxy

/**
 * Created by yocn on 2018/11/29.
 */
class AlgoFactory {
    companion object {
        fun create(handler: DynamicProxy): IAlgoProxy {
            val cs = arrayOf(IAlgoProxy::class.java)
            val interfs = handler.proxyImpl::class.java.interfaces
            LogUtil.d("yocn interfaces-name->  ${interfs[0].simpleName} 2->${interfs[0].name} " )
            LogUtil.d("yocn interfaces-name->  ${cs[0].simpleName} 2->${cs[0].name} " )
            LogUtil.d("handler.proxyImpl::class->${handler.proxyImpl::class}")

            val proxy: IAlgoProxy = Proxy.newProxyInstance(handler.proxyImpl.javaClass.classLoader, cs, handler) as IAlgoProxy
            return proxy
        }
    }
}