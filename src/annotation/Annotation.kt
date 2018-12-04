package annotation

import jdk.internal.org.objectweb.asm.tree.AnnotationNode

/**
 * Created by yocn on 2018/12/4.
 */

@Target(AnnotationTarget.FUNCTION)
annotation class Fancy(
        val msg: String
)



