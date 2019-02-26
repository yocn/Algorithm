package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/2/26.
 * 给一个字符串，给出他的所有排列
 */
public class ArrangeAllString {
    public void test() {
        pailie("abc", "", 0);
    }

    private void pailie(String s, String temp, int level) {//参数设计地尽量地简洁
        if (s.length() == 0) {
            System.out.println(temp);
            return;
        }
        level++;
        for (int i = 0; i < s.length(); i++) {
            String news = s.substring(0, i) + s.substring(i + 1, s.length());//去掉String中的第i个字母
            LogUtil.Companion.d("news->" + news + " level->" + level + "->" + (temp + s.charAt(i)));
            pailie(news, temp + s.charAt(i), level);
        }
    }
}
