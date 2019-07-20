package algorithm.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yocn on 2019/7/19.
 */
public class Easy {
    //        LogUtil.Companion.d("removeDuplicates->" + removeDuplicates2("abbaca"));

    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
    //https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
    //nums = [0,0,1,1,1,2,2,3,3,4],-> nums = [0,1,2,3,4],
    public int removeDuplicates(int[] nums) {
        if (nums == null) return -1;
        int index = -1;
        int current = nums.length == 0 ? -1 : (nums[0] - 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != current) {
                current = nums[i];
                swap(nums, ++index, i);
            }
        }
        return index + 1;
    }

    private static void swap(int[] src, int i, int j) {
        int temp = src[i];
        src[i] = src[j];
        src[j] = temp;
    }

    /**
     * 输入："abbaca"
     * 输出："ca"
     * 解释： https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/submissions/
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     *
     * @param S
     * @return
     */
    public static String removeDuplicates(String S) {
        if (S == null || "".equals(S)) return S;
        char[] chars = S.toCharArray();
        Stack<Character> temp = new Stack<>();
        for (char aChar : chars) {
            if (temp.empty() || temp.peek() != aChar) {
                temp.push(aChar);
            } else {
                temp.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : temp) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static String removeDuplicates2(String S) {
        if (S == null || "".equals(S)) return S;
        char[] chars = S.toCharArray();
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (temp.isEmpty() || temp.get(temp.size() - 1) != chars[i]) {
                temp.add(chars[i]);
            } else {
                temp.remove(temp.size() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : temp) {
            sb.append(c);
        }
        return sb.toString();
    }
}
