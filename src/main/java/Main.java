import algorithm.ArrangeAllString;
import algorithm.EightQueen;
import algorithm.GenerateParenttheses;
import algorithm.RegularExpressionMatching;
import okhttp.TestOKHttp;
import okio.testOKIO;
import proxy.SimpleDynamicProxy;
import retrofit.TestRetrofit;
import testRecursion.TestRecursion;

import java.io.IOException;

/**
 * Created by yocn on 2018/12/4.
 * //
 */
public class Main {
    //    public static void main(String[] args) {
////        System.out.println("asdadsa");
////        AnnoParser parser = new AnnoParser();
////        parser.parse(IAlgoProxy.class);
////        int[] indexs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
////        for (int i = 0; i < 10; ++i) {
////            System.out.println("i->" + i + " index->" + indexs[i]);
////        }
////        for (int i = 0; i < 10; i++) {
////            System.out.println("i->" + i + " index->" + indexs[i]);
////        }
//
////        LogUtil.Companion.d("yocn Function->" + Constant.ifInConstents(Constant.Function.class, 100));
//
////        LogUtil.Companion.d("yocn Function->" + Constant.Function.TYPE_TOAST);
////        LogUtil.Companion.d("yocn Function->" + Constant.Function.TYPE_SHOW_LOCAL_IMAGE_0);
//
////        ThreadLocal threadLocal;
////        LinkedHashMap ma;
////        String string = null;
////        HashMap<Integer, String> map = new HashMap<>();
////        map.put(null, "123");
////        System.out.println("0     ->" + map.get(null) + " v->" + hash(null));
////
////        System.out.println("1     ->" + map.hashCode() + " v->" + (map.hashCode() >>> 16) + " x->" + (map.hashCode() ^ (map.hashCode() >>> 16)));
//
////        new ATestLock().doTest();
////        new TestTreeMap().test();
//
//        Random random = new Random();
//        StringBuffer sb = new StringBuffer();
//        sb.append("{");
//        for (int i = 0; i < 47; i++) {
//            sb.append("x:").append(random.nextInt(10000)).append(",y:").append(random.nextInt(10000)).append("|");
//        }
//        sb.append("}");
//        try {
//            int srcLength = sb.toString().length();
//            byte[] dest = GZIPUtils.compress(sb.toString());
//            String ss = new String(dest, "utf-8");
//            LogUtil.Companion.d("" + ss);
//
//
//            int destLength = dest.length;
//            LogUtil.Companion.d("" + (float) srcLength / destLength);
//            LogUtil.Companion.d("" + sb.toString());
//            LogUtil.Companion.d("" + sb.toString().length() + "|" + dest.length);
//            LogUtil.Companion.d("" + GZIPUtils.uncompressToString(ss.getBytes()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    static final int hash(Object key) {
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//}

    public static void main(String[] args) throws IOException {
//        ZigzagConversion.test();
//        Palindromic.test();
//        LongestSubString.test();
//        IsPalindromic.test();
//        RegularExpressionMatching.test();
//        EightQueen.test();
//            new TraverseBinaryTree().test();
//            new SimpleDynamicProxy().test();
//        TestRetrofit.retrofitGetWeather();
//        TestOKHttp.test();
//        new TestRecursion(0).process();
//        testOKIO.test();
//        new GenerateParenttheses().test();
        new ArrangeAllString().test();
    }
}