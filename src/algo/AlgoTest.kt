package algo

import proxy.IAlgoProxy
import util.LogUtil

/**
 * Created by yocn on 2018/11/29.
 */
class AlgoTest : IAlgoProxy {
    override fun testAlgo(x: Any) {
        LogUtil.d("testAlgo")
    }

    override fun testAlgo2() {
        LogUtil.d("testAlgo2")
    }
}