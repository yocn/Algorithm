package proxy

import annotation.Fancy

/**
 * Created by yocn on 2018/11/29.
 */
interface IAlgoProxy {
    @Fancy("startPlay msg") fun startPlay(x: Any)

    @Fancy("stopPlay")
    fun stopPlay()
}