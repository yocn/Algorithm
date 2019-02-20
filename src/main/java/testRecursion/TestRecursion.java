package testRecursion;

import util.LogUtil;

/**
 * Created by yocn on 2019/2/19.
 */
public class TestRecursion {
    public int index = 0;

    public TestRecursion(int index) {
        this.index = index;
    }

    public void process() {
        if (index > 10) {
            return;
        }
        TestRecursion testRecursion = new TestRecursion(index++);
        LogUtil.Companion.d("index->" + testRecursion.index);
    }
}
