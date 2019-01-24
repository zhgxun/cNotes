package github.banana.letcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串, 请你找出其中不含有重复字符的 最长子串 的长度
 * <p>
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * a. 暴力法
     * <p>
     * 逐个检查所有的子字符串, 看它是否不含有重复的字符
     * 为了枚举给定字符串的所有子字符串, 我们需要枚举它们开始和结束的索引
     * 要检查一个字符串是否有重复字符, 我们可以使用集合
     * 我们遍历字符串中的所有字符, 并将它们逐个放入 set 中
     * 在放置一个字符之前, 我们检查该集合是否已经包含它
     * 如果包含, 我们会返回 false, 循环结束后, 我们返回 true
     *
     * @param s 原始字符串
     * @return 无重复最长子字符串长度
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                // 暴力枚举字符串所有子字符串
                if (unique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    /**
     * 检查一段字符串是否重复
     *
     * @param s     字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return 重复返回 false, 不重复返回 true
     */
    public static boolean unique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * b. 滑动窗口
     *
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
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
        }
        return ans;
    }
}
