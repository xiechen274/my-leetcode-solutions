package hot100;

/**
 * @author edward
 * @description 检测链表是否有环
 * @date 2025/3/22
 */

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        // 边界检查：空链表或单节点无环
        if (head == null || head.next == null) {
            return null;
        }

        // 步骤1：快慢指针检测环
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 步骤2：从头和相遇点同步移动，寻找环入口
                ListNode ptr1 = head;
                ListNode ptr2 = fast;
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1; // 循环结束后返回环入口
            }
        }

        // 无环，返回 null
        return null;
    }
}
