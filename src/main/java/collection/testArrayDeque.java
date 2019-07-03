package collection;

import util.LogUtil;

import java.util.ArrayDeque;

/**
 * Created by yocn on 2019/7/1.
 */
public class testArrayDeque {
    public static void test() {

//        LinkedList list;
//        ArrayList l;
        ArrayDequeCopy<Integer> queue = new ArrayDequeCopy<>();
        for (int i = 0; i < 70; i++) {
            if (i % 2 == 0) {
                queue.addFirst(i);
            } else {
                queue.addLast(i);
            }
        }
//        ququq.add(1);
//        int s = ququq.size();
//        LogUtil.Companion.d("->" + ((Integer.MAX_VALUE >> 2) - 1));
//        LogUtil.Companion.d("->" + (Integer.MAX_VALUE >> 2 - 1));
//        CountDownLatch latch;
//        int i = 33;
//        print(i, 1);
//        print(i | 1, 2);
//        LogUtil.Companion.d("" + (1 << 30));
//        LogUtil.Companion.d("" + (Integer.MAX_VALUE >> 2));
//        allocateElements(1 << 30);
//        allocateElements((Integer.MAX_VALUE));
//        LogUtil.Companion.d("" + ((1 - 14) & 15));
//        LogUtil.Companion.d("" + ((-3) & 31));
//        LogUtil.Companion.d("" + Integer.toBinaryString(-1));
//        LogUtil.Companion.d("" + Integer.toBinaryString(Integer.MAX_VALUE));
    }

    private static void print(int i, int digit) {
        LogUtil.Companion.d("" + Integer.toBinaryString(i));
        LogUtil.Companion.d("" + Integer.toBinaryString(i >>> digit));
        LogUtil.Companion.d("" + Integer.toBinaryString(i | i >>> digit));
    }

    private static final int MIN_INITIAL_CAPACITY = 8;

    private static void allocateElements(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        // Find the best power of two to hold elements.
        // Tests "<=" because arrays aren't kept full.
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString((initialCapacity >>> 1)));
//            initialCapacity |= (initialCapacity >>> 1);
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString(initialCapacity >>> 1));
//            initialCapacity |= (initialCapacity >>> 2);
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString(initialCapacity >>> 1));
//            initialCapacity |= (initialCapacity >>> 4);
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString(initialCapacity >>> 1));
//            initialCapacity |= (initialCapacity >>> 8);
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString(initialCapacity >>> 1));
//            initialCapacity |= (initialCapacity >>> 16);
//            LogUtil.Companion.d("" + Integer.toBinaryString(initialCapacity) + " " + Integer.toBinaryString(initialCapacity >>> 1));

            int initialCapacity1 = (initialCapacity >>> 1);
            int temp1 = initialCapacity;
            initialCapacity = temp1 | initialCapacity1;
            LogUtil.Companion.d("" + Integer.toBinaryString(temp1) + "|" + Integer.toBinaryString(initialCapacity1) + "|" + Integer.toBinaryString(initialCapacity));
            int initialCapacity2 = (initialCapacity >>> 2);
            int temp2 = initialCapacity;
            initialCapacity = temp2 | initialCapacity2;
            LogUtil.Companion.d("" + Integer.toBinaryString(temp2) + "|" + Integer.toBinaryString(initialCapacity2) + "|" + Integer.toBinaryString(initialCapacity));
            int initialCapacity4 = (initialCapacity >>> 4);
            int temp4 = initialCapacity;
            initialCapacity = temp4 | initialCapacity4;
            LogUtil.Companion.d("" + Integer.toBinaryString(temp4) + "|" + Integer.toBinaryString(initialCapacity4) + "|" + Integer.toBinaryString(initialCapacity));
            int initialCapacity8 = (initialCapacity >>> 8);
            int temp8 = initialCapacity;
            initialCapacity = temp8 | initialCapacity8;
            LogUtil.Companion.d("" + Integer.toBinaryString(temp8) + "|" + Integer.toBinaryString(initialCapacity8) + "|" + Integer.toBinaryString(initialCapacity));
            int initialCapacity16 = (initialCapacity >>> 16);
            int temp16 = initialCapacity;
            initialCapacity = temp16 | initialCapacity16;
            LogUtil.Companion.d("" + Integer.toBinaryString(temp16) + "|" + Integer.toBinaryString(initialCapacity16) + "|" + Integer.toBinaryString(initialCapacity));


            initialCapacity++;

            LogUtil.Companion.d("initialCapacity->" + initialCapacity);
            if (initialCapacity < 0) {   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
            }
            LogUtil.Companion.d("initialCapacity->" + initialCapacity);
        }
    }

}
