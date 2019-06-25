package testJava;

/**
 * Created by yocn on 2019/6/25.
 */
public class testStaticCodeLoad {
    public void test() {
        new Thread(() -> {
            try {
                SingleInstance.get();
                Thread.sleep(3000);
                SingleInstance.getInstance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void testSingleTon() {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}
