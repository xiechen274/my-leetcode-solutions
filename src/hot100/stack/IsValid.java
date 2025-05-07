package hot100.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author xlj
 * @date 2025-05-07
 * @description 有效的括号
 */

public class IsValid {

    public boolean isValid(String s) {
        if(s.length() == 1){
            return false;
        }
        //初始化
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        //遍历char数组
        for(char c : s.toCharArray()){
            //现有左括号才有右括号，把左括号全部入栈
            if(map.containsValue(c)){
                stack.push(c);
            }else if(map.containsKey(c)){
                //现在开始遍历右括号部分
                if(stack.isEmpty() || stack.pop() != map.get(c)){
                    return false;
                }
            }

        }
        return stack.isEmpty(); //如果完全匹配的话isEmpry是true

    }

    public static void main(String[] args) {
        IsValid solution = new IsValid();
        System.out.println(solution.isValid("()")); // true
        System.out.println(solution.isValid("()[]{}")); // true
        System.out.println(solution.isValid("(]")); // false
    }
}
