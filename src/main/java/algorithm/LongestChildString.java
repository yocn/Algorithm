package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/1/25.
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestChildString {
    public void test() {
        get("abcabcbb");
        get("pwwkew");
        get("bbbbbb");
    }

    public void get(String src) {
        List<Character> longest = new ArrayList<>();
        char[] chars = src.toCharArray();
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (temp.contains(chars[i])) {
                int index = temp.indexOf(chars[i]);
                if (index >= temp.size() - 1) {
                    temp.clear();
                } else {
                    temp = temp.subList(index + 1, temp.size() - 1);
                }
            }
            temp.add(chars[i]);
            if (temp.size() > longest.size()) {
                longest = new ArrayList<>(temp);
            }
        }
        LogUtil.Companion.d(longest.toString());
    }

}
