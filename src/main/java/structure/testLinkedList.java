package structure;

import util.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by yocn on 2019/7/17.
 * 测试LinkedList的for循环
 */
public class testLinkedList {
    public void test() {
        LinkedListCP<Integer> list = new LinkedListCP<>();
//        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        int index = 0;

        long time1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            index = list.get(i);
        }
        long time2 = System.currentTimeMillis();
        LogUtil.Companion.d("1:" + (time2 - time1) + " index->" + index);
        for (int i : list) {
            index = i;
        }
        long time3 = System.currentTimeMillis();
        LogUtil.Companion.d("2:" + (time3 - time2) + " index->" + index);
        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            index = iterator.next();
        }
        long time4 = System.currentTimeMillis();
        LogUtil.Companion.d("3:" + (time4 - time3) + " index->" + index);
    }
}
