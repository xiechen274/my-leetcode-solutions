package hot100.stack;

import java.lang.management.MonitorInfo;

/**
 * @author xlj
 * @date 2025-05-08
 * @description 最小栈
 * 核心思路: 使用一个辅助数组来维护最小值，才能保证时间复杂度为o1
 */

public class MinStack {

    //size指向下一个被插入的位置
    int size;
    int minSize;
    int[] stackArr;
    int[] minArr;


    public MinStack() {
        size = 0;
        stackArr = new int[100000];
        minArr = new int[100000];
        minSize = 0;
    }

    public void push(int val) {
        //是第一个入栈元素
        if(this.size == 0){
            minArr[minSize++] = val;
        }else{
            if(minArr[minSize - 1] >= val){
                minArr[minSize++] = val;
            }
        }
        stackArr[size++] = val;
    }

    public void pop() {
        if (!this.isEmpty()) {
            //检查是否是最小值
            if (stackArr[size - 1] == minArr[minSize - 1]) {
                minSize--;
            }
            size--;
        }
    }

    public int top() {
        return stackArr[size - 1];
    }

    public int getMin() {
        return minArr[minSize - 1];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        System.out.println("Push 0, Min: " + minStack.getMin()); // 0
        minStack.push(1);
        System.out.println("Push 1, Min: " + minStack.getMin()); // 0
        minStack.push(0);
        System.out.println("Push 0, Min: " + minStack.getMin()); // 0
        System.out.println("GetMin: " + minStack.getMin()); // 0
        minStack.pop();
        System.out.println("Pop 0, Min: " + minStack.getMin()); // 0
        System.out.println("GetMin: " + minStack.getMin()); // 0
    }

}
