package hot100;

/**
 * https://leetcode.cn/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-100-liked
 *
 * @author edward
 * @description 141. 环形链表
 * @date 2025/3/22
 */

public class HasCycle {
    //快慢指针
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        //快指针一次走两个，这样保证快慢相遇
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
