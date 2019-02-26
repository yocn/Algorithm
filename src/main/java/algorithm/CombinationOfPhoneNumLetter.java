package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yocn on 2019/2/25.
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 2->abc    3->def
 * 4->ghi    5->jkl    6->mno
 * 7->pqrs   8->tuv    6->xyz
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class CombinationOfPhoneNumLetter {
    private Map<Character, String> mLetterMap = new HashMap<>();

    public CombinationOfPhoneNumLetter() {
        mLetterMap.put('2', "abc");
        mLetterMap.put('3', "def");
        mLetterMap.put('4', "ghi");
        mLetterMap.put('5', "jkl");
        mLetterMap.put('6', "mno");
        mLetterMap.put('7', "pqrs");
        mLetterMap.put('8', "tuv");
        mLetterMap.put('9', "wxyz");
    }

    public void test() {
        List<String> list = letterCombinations("932");
        LogUtil.Companion.d(list.toString());
    }

    List<String> list = new ArrayList<>();
    String digits;

    private List<String> letterCombinations(String digits) {
        this.digits = digits;
        char[] srcChars = digits.toCharArray();
        List<String> srcList = new ArrayList<>();
        for (char c : srcChars) {
            String ss = mLetterMap.get(c);
            srcList.add(ss);
        }
        LogUtil.Companion.d("src->" + srcList.toString());
        combine(srcList, "", 0);

        return list;
    }

    private void combine(List<String> src, String temp, int index) {
        if (index == digits.length()) {
            list.add(temp);
            return;
        }
        index++;
        String currentString = src.get(index - 1);
        char[] chars = currentString.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            String ss = temp + chars[j];
            LogUtil.Companion.d(index + " - " + currentString + " length->" + digits.length() + " index->" + index + " temp->" + temp + " chars[j]->" + chars[j]);
            combine(src, ss, index);
        }
    }

}
