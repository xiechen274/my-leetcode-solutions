package hot100;

import java.util.Stack;

/**
 * @author xlj
 * @date 2025-05-07
 * @description 回文链表Stack
 */

public class IsPalindromeUseStack {
    public boolean isPalindromeUseStack(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        //将元素入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //元素出栈并且与原来的链表进行对比时候是回文链表
        cur = head;
        while (!stack.isEmpty()) {
            if(cur.val != stack.pop().val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        //构造[1,2,2,1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        IsPalindromeUseStack isPalindromeUseStack = new IsPalindromeUseStack();
        System.out.println(isPalindromeUseStack.isPalindromeUseStack(head));
    }
}
