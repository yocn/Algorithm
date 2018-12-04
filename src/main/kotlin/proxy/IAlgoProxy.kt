package proxy

import annotation.Fancy

/**
 * Created by yocn on 2018/11/29.
 */
interface IAlgoProxy {
    @Fancy("testAlgo msg") fun testAlgo(x: Any)

    @Fancy("testAlgo2")
    fun testAlgo2()
}