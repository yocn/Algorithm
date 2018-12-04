import algo.AlgoTest
import annotation.AnnotationExpression
import proxy.AlgoFactory
import proxy.DynamicProxy
import proxy.IAlgoProxy
import util.LogUtil

fun main(args: Array<String>) {
    LogUtil.d("hello")
    val algo = DynamicProxy(AlgoTest())
    val IAlgoProxyImpl = AlgoFactory.create(algo)
    IAlgoProxyImpl.testAlgo(2)
    IAlgoProxyImpl.testAlgo2()
    AnnotationExpression().expression(IAlgoProxy::class.java)
}