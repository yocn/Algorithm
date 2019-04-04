package testJava;

import algorithm.ITestInterface;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import util.LogUtil;

/**
 * Created by yocn on 2019/3/25.
 */
public class testJavaObjectStoreSize implements ITestInterface {

    @Override
    public void test() {

        long a = ObjectSizeCalculator.getObjectSize('a');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            sb.append("a");
        }
        String s = "http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55http://app.mafengwo.cn/index?channel_id=55" +
                "";
        long bb = ObjectSizeCalculator.getObjectSize(s);
        LogUtil.Companion.d("a->" + a);
        LogUtil.Companion.d("bbb->" + bb);
    }

    public static void test2() throws MyException {
        MyException myException = new MyException("sadasd");
        myException.object = "";
        throw myException;
    }

    public static class MyException extends Exception {
        public Object object;

        public MyException(String message) {
            super(message);
        }
    }
}
