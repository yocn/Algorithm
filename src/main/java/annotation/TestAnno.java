package annotation;

/**
 * Created by yocn on 2018/12/4.
 */
public interface TestAnno {
    @Fancy(msg = "test1")
    void test1();

    @Fancy(msg = "test2")
    void test2();
}
