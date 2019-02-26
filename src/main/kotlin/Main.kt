import algo.AlgoTest
import annotation.AnnotationExpression
import proxy.AlgoFactory
import proxy.DynamicProxy
import proxy.IAlgoProxy
import util.LogUtil

fun main(args: Array<String>) {
//    LogUtil.d("hello")
    val algo = DynamicProxy(AlgoTest())
    val IAlgoProxyImpl = AlgoFactory.create(algo)
    algo.let{

    }
    IAlgoProxyImpl.startPlay("我开始播放")
    IAlgoProxyImpl.stopPlay()
//    AnnotationExpression().expression(IAlgoProxy::class.java)
}