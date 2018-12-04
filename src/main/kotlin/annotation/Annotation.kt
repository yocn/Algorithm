package annotation

/**
 * Created by yocn on 2018/12/4.
 */

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Fancy(
        val msg: String
)



