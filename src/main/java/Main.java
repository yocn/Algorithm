import DynamicProgramming.Fibonacci;
import algorithm.*;
import algorithm.backtracing.CombinationNum2;
import algorithm.backtracing.Permutations;
import algorithm.base.BinarySearch;
import algorithm.base.BubbleSort;
import algorithm.base.SelectionSort;
import testAQS.TestAQS;
import util.LogUtil;

import javax.script.ScriptEngineManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

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
//        new TraverseBinaryTree().test();
//        new SimpleDynamicProxy().test();
//        TestRetrofit.retrofitGetWeather();
//        TestOKHttp.test();
//        new TestRecursion(0).process();
//        testOKIO.test();
//        new GenerateParenttheses().test();
//        new ArrangeAllString().test();
//        new CombinationOfPhoneNumLetter().test();
//        new CombinationNum().test();
//        new CombinationNum2().test();
//        new Permutations().test();
//        new Fibonacci().test();
//        new TestAQS().test();
//        new SpiralMatrix().test();
//        new PascalTriangle().test();
//        new SprialMatrixII().test();
//        new LongestUnivaluePath().test();
//        new RomanToInteger().test();
//        new ReverseInteger().test();
//        new Sum3().test();
//        new SumOfLeftLeaves().test();
//        new Sum2().test();
//        new Atoi().test();
//        new ChainAdd().test();
//        new GetStep().test();
//        new BinarySearch().test();
//        ITestInterface test = new BubbleSort();
        ITestInterface test = new SelectionSort();
        test.test();
    }
}