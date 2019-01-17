import lock.ATestLock;

/**
 * Created by yocn on 2018/12/4.
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println("asdadsa");
//        AnnoParser parser = new AnnoParser();
//        parser.parse(IAlgoProxy.class);
//        int[] indexs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        for (int i = 0; i < 10; ++i) {
//            System.out.println("i->" + i + " index->" + indexs[i]);
//        }
//        for (int i = 0; i < 10; i++) {
//            System.out.println("i->" + i + " index->" + indexs[i]);
//        }

//        LogUtil.Companion.d("yocn Function->" + Constant.ifInConstents(Constant.Function.class, 100));

//        LogUtil.Companion.d("yocn Function->" + Constant.Function.TYPE_TOAST);
//        LogUtil.Companion.d("yocn Function->" + Constant.Function.TYPE_SHOW_LOCAL_IMAGE_0);

//        ThreadLocal threadLocal;
//        LinkedHashMap ma;
//        String string = null;
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(null, "123");
//        System.out.println("0     ->" + map.get(null) + " v->" + hash(null));
//
//        System.out.println("1     ->" + map.hashCode() + " v->" + (map.hashCode() >>> 16) + " x->" + (map.hashCode() ^ (map.hashCode() >>> 16)));

        new ATestLock().doTest();
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
