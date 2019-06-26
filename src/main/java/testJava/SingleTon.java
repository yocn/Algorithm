package testJava;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/25.
 * 详细解释：https://www.jianshu.com/p/d4ea62ade8d8
 */
class SingleTon {
    private static SingleTon singleTon = new SingleTon(); // ② 给singleTon分配空间并设置初始值为null  ⑤singleTon初始化为 new SingleTon()
    public static int count1; // ③ count1分配空间并设置初始值为0 ⑧ count1没有初始化值，故保持当前的值，当前值为1
    public static int count2 = 0; // ④ count2分配空间并设置初始值为0 ⑨ count2 初始化赋值为0

    private SingleTon() { //  ⑥ SingleTon构造方法
        //当前 count1 = 0  count2 = 0
        count1++;
        count2++;
        //++完之后 count1 = 1  count2 = 1
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}


