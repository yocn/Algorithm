import util.LogUtil

/**
 * Created by yocn on 2018/12/5.
 */
class LogicTool {

    companion object {
        private var mInstance: LogicTool? = null

        fun getInstance(): LogicTool? {
            if (mInstance == null) {
                synchronized(LogicTool::class.java) {
                    if (mInstance == null) {
                        mInstance = LogicTool()
                    }
                }
            }
            return mInstance
        }
    }

    fun start(obj: Any) {
        LogUtil.d("yocn LogicTool start->" + obj.toString())
    }

    fun stop() {
        LogUtil.d("yocn LogicTool stop")
    }

}