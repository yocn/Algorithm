package algo

import proxy.IAlgoProxy
import util.LogUtil

/**
 * Created by yocn on 2018/11/29.
 */
class AlgoTest : IAlgoProxy {
    override fun startPlay(x: Any) {
        LogUtil.d("startPlay")
    }

    override fun stopPlay() {
        LogUtil.d("stopPlay")
    }
}