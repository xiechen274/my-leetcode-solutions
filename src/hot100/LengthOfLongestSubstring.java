package hot100;
import java.util.*;
/**
 * @author edawrd
 * @version 1.0
 * @date 2025-04-18
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring(s));

    }
    //滑动窗口解法
    public int lengthOfLongestSubstring(String s) {
        int nums = 0;
        //定义左右指针
        int r = 0;
        int l = 0;

        //定义一个set集合，用来存储字符
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                r++;//右指针向右移动
                nums = Math.max(nums,r-l);//更新最大值
            }else{
                //Set中已经有该元素,左边界向右移动
                set.remove(s.charAt(l));
                l++;
            }
        }
        return nums;
    }
}
