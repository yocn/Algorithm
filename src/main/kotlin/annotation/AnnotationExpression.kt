package annotation

import proxy.IAlgoProxy
import util.LogUtil
import java.lang.reflect.Field

/**
 * Created by yocn on 2018/12/4.
 */
class AnnotationExpression {
    fun expression(clazz: Class<IAlgoProxy>) {
        val array = clazz.declaredMethods
        array.forEach {
            if (it.isAnnotationPresent(Fancy::class.java)) {
                val fancy = it.getAnnotation(Fancy::class.java)
                it.isAccessible = true
                LogUtil.d(" fancy.msg->" + fancy.msg)
            }
        }
    }
}
