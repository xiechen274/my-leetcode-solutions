package hot100.stack;

import java.util.Stack;


/**
 * @author xlj
 * @date 2025-05-09
 * @description 每日温度
 */

public class DailyTemperatures {

    //暴力解法，会超时
    public int[] dailyTemperatures1(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[]{0};
        }
        int[] retArr = new int[temperatures.length];
        //双重循环遍历
        for(int i = 0; i < temperatures.length - 1; i++){
            int j = i + 1;
            while(j < temperatures.length && temperatures[i] - temperatures[j] >= 0){
                j++;
            }
            //判断是否存在;
            if(j == temperatures.length){
                retArr[i] = 0;
            }else {
                retArr[i] = j - i;
            }
        }
        return retArr;
    }


                                                                                                                                
    //单调栈解法
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 1){
            return new int[]{0};
        }
        //定义一个单调栈存储遍历过的数
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        //入栈
        for(int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int peekIndex = stack.pop();
                answer[peekIndex] = i - peekIndex;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = solution.dailyTemperatures(temperatures);
        for (int val : result) {
            System.out.print(val + " ");
        } // 输出: 1 1 4 2 1 1 0 0
    }


}
