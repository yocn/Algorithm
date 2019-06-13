package util;

/**
 * Created by yocn on 2019/4/27.
 */
public class ProductMethod {

    static int index = 0;
    static int realIndex = 0;
    static int[] src = {5, 7, 3, 1, 4, 9, 2, 8, 0, 6, 15, 17, 13, 11, 14, 19, 12, 18, 10, 16, 25, 27, 23, 21, 24, 29, 22, 28, 20, 26, 35, 37, 33, 31, 34, 39, 32, 38, 30, 36, 45, 47, 43, 41, 44, 49, 42, 48, 40, 46, 55, 57, 53, 51, 54, 59, 52, 58, 50, 56, 65, 67, 63, 61, 64, 69, 62, 68, 60, 66, 75, 77, 73, 71, 74, 79, 72, 78, 70, 76, 85, 87, 83, 81, 84, 89, 82, 88, 80, 86, 95, 97, 93, 91, 94, 99, 92, 98, 90, 96};

    public static void productMethod() {
//        for (int i = 0; i < 10000; i++) {
//            System.out.println("private void method" + i + "(){");
//            if (i == 0) {
//                System.out.println("    method" + 9999 + "();");
//            } else {
//                System.out.println("    method" + (i - 1) + "();");
//            }
//            System.out.println("}");
//        }
        getIndex();
    }

    public static int getIndex() {
        StringBuilder sb = new StringBuilder();
        while (index < 10) {
            for (int i = 0; i < src.length; i++) {
                realIndex = index * 10 + src[i];
                sb.append(",").append(realIndex);
//                LogUtil.Companion.d("i->" + realIndex);
            }
            index++;
        }
        LogUtil.Companion.d("{" + sb + "}");
        return realIndex;
    }
}
