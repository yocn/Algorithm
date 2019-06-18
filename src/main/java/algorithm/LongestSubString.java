package algorithm;

import util.LogUtil;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
public class LongestSubString {
    public static void test() {
        LogUtil.Companion.d("i->" + lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Queue<Character> queue = new LinkedList<>();
//        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (queue.contains(currentChar)) {
                int length = queue.size();
                if (length > maxLength) {
                    maxLength = length;
                }
                for(;queue.remove() != currentChar;){

                }
                queue.add(currentChar);
                LogUtil.Companion.d("包含i->" + queue.size() + " maxLength->" + maxLength + " " + queue.toString());
            } else {
                queue.add(currentChar);
                maxLength = queue.size() > maxLength ? queue.size() : maxLength;
                LogUtil.Companion.d("不i->" + queue.size() + " " + queue.toString());
            }
        }
        return maxLength;
    }
}
