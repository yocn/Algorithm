import algo.AlgoTest
import proxy.AlgoFactory
import proxy.DynamicProxy
import util.LogUtil

fun main(args: Array<String>) {
    LogUtil.d("hello")
    val algo = DynamicProxy(AlgoTest())
    val IAlgoProxyImpl = AlgoFactory.create(algo)
    IAlgoProxyImpl.testAlgo(2)
    IAlgoProxyImpl.testAlgo2()
}