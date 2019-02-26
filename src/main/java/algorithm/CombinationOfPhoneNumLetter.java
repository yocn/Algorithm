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
    private Map<Character, Character[]> mLetterMap = new HashMap<>();

    CombinationOfPhoneNumLetter() {
        mLetterMap.put('2', new Character[]{'a', 'b', 'c'});
        mLetterMap.put('3', new Character[]{'d', 'e', 'f'});
        mLetterMap.put('4', new Character[]{'g', 'h', 'i'});
        mLetterMap.put('5', new Character[]{'j', 'k', 'l'});
        mLetterMap.put('6', new Character[]{'m', 'n', 'o'});
        mLetterMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        mLetterMap.put('8', new Character[]{'t', 'u', 'v'});
        mLetterMap.put('9', new Character[]{'x', 'y', 'z'});
    }

    public void test() {
        List<String> list = letterCombinations("23");
        LogUtil.Companion.d(list.toString());
    }

    private List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();


        List<String> list = new ArrayList<>();
        return list;
    }

}
