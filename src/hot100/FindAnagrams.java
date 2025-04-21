package hot100;

import java.util.*;

/**
 * 异位词字符串
 *给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @author edawrd
 * @version 1.0
 * @date 2025-04-21
 */
public class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> retList = new ArrayList<>();
        //窗口初始边界
        int left = 0;
        int right = p.length() - 1;
        //对p的字符串先进行ascii排序
        char[] pChar = p.toCharArray();
        Arrays.sort(pChar);
        while (right < s.length()) {
            String substring = s.substring(left, right + 1);
            char[] subArr =  substring.toCharArray();
            Arrays.sort(subArr);
            if (Arrays.equals(subArr,pChar)) {
                retList.add(left);
            }
            right++;
            left++;
        }
        return retList;
    }
}
