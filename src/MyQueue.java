import java.util.Stack;

/**
 * 实现一个使用栈实现队列的类 MyQueue。
 *
 * <p>力扣题目链接：https://leetcode.cn/problems/implement-queue-using-stacks/
 *
 * <p>题目描述：
 * 请你仅使用两个栈实现一个队列，使得支持以下的操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * <p>说明：
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque (双端队列) 来模拟一个栈，只要是标准的栈操作即可。
 *
 * <p>进阶：
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？ 换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 */
public class MyQueue {

    private Stack<Integer> in; // 用于存放元素的第一个栈
    private Stack<Integer> out; // 用于帮助实现队列功能的辅助栈

    /** 初始化数据结构 */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    private void inToOut(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }
    }

    /**
     * 将元素 x 推到队列末尾
     *
     * @param x 要推入的元素
     */
    public void push(int x) {
        // 实现入队逻辑
        in.push(x);
        inToOut();
    }

    /**
     * 从队列开头移除并返回该元素
     *
     * @return 队列开头的元素
     */
    public int pop() {
        // 实现出队逻辑
        inToOut();
        return out.pop();
    }

    /**
     * 获取队列开头的元素
     *
     * @return 队列开头的元素
     */
    public int peek() {
        // 实现获取队首元素逻辑
        inToOut();
        return out.peek();
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列是否为空
     */
    public boolean empty() {
        // 实现判断队列是否为空的逻辑
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // 应输出 1
        System.out.println(queue.pop());  // 应输出 1
        System.out.println(queue.empty()); // 应输出 false
    }
}