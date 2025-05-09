package hot100.stack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @author xlj
 * @date 2025-05-09
 * @description 字符串解码
 */

public class DecodeString {

    public String decodeString(String s) {
        //初始化变量
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        int num = 0;
        StringBuilder currStr = new StringBuilder(); //存放需要压入栈的字符

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0'); // 累积多位数字
            } else if (c == '[') {
                numStack.push(num);
                strStack.push(currStr.toString());
                num = 0; // 重置
                currStr = new StringBuilder();
            } else if (c == ']') {
                int k = numStack.pop(); //拿出这个需要弹出来的次数
                StringBuilder temp = new StringBuilder(strStack.pop());
                for(int i = 1; i <= k; i++){
                    temp.append(currStr);
                }
                currStr = temp;//更新当前字符串
            } else {
                currStr.append(c); // 追加字母
            }
        }
        return currStr.toString();
    }

    public static void main(String[] args) {
        DecodeString solution = new DecodeString();
        System.out.println(solution.decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(solution.decodeString("3[a2[c]]")); // "accaccacc"
        System.out.println(solution.decodeString("2[abc]3[cd]ef")); // "abcabccdcdcdef"
    }
}
