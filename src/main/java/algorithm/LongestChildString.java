package algorithm;

import util.LogUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        int i1 = getLongestString("abcabcbb");
//        int i2 = lengthOfLongestSubstring("pwwkew");
//        int i3 = lengthOfLongestSubstring("bbbbbb");
        LogUtil.Companion.d(i1);
//        LogUtil.Companion.d(i2);
//        LogUtil.Companion.d(i3);
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

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
            LogUtil.Companion.d("set->" + set.toString());
        }
        return ans;
    }

    public int getLongestString(String s) {
        int max = 0;
        int i = 0;
        int j = 0;
        Set<Character> sets = new HashSet<>();
        while (j < s.length()) {
            if (!sets.contains(s.charAt(j))) {
                sets.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                sets.remove(s.charAt(i++));
            }
        }
        return max;
    }

}
