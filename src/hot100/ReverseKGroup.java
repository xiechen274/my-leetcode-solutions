package hot100;

/**
 * @author edawrd
 * @version 1.0
 * @date 2025-04-22
 */
public class ReverseKGroup {
    // 链表节点定义
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 核心方法：K 个一组翻转链表
    public ListNode reverseKGroup(ListNode head, int k) {
        // 空链表或 k=1，无需反转
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode preNode = dummy;

        while (true) {
            // 定位一组 k 个节点
            ListNode lowNode = preNode.next;
            ListNode fastNode = lowNode;
            int count = 0;

            // 快指针走 k 步，检查是否有足够节点
            while (count < k && fastNode != null) {
                fastNode = fastNode.next;
                count++;
            }

            // 如果不足 k 个节点，停止反转
            if (count < k) {
                break;
            }

            // 反转 lowNode 到 fastNode 之间的节点
            ListNode curr = lowNode;
            ListNode prev = null;
            ListNode nextGroup = fastNode; // 保存下一组的起点

            // 反转当前组（从 lowNode 到 fastNode 前一个节点）
            for (int i = 0; i < k; i++) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // 连接反转后的组
            preNode.next = prev; // 前驱指向新头（反转后的第一个节点）
            lowNode.next = nextGroup; // 原头（反转后变为尾）连接下一组

            // 更新 preNode 为当前组的尾节点（lowNode）
            preNode = lowNode;
        }

        return dummy.next;
    }

    // 辅助方法：从数组创建链表
    private ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    // 辅助方法：打印链表
    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    // main 方法：测试代码
    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();

        // 测试用例 1：1 -> 2 -> 3 -> 4 -> 5, k = 2
        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode head1 = reverseKGroup.createList(arr1);
        System.out.print("原始链表: ");
        reverseKGroup.printList(head1);
        ListNode result1 = reverseKGroup.reverseKGroup(head1, k1);
        System.out.print("翻转后链表: ");
        reverseKGroup.printList(result1);

        // 测试用例 2：1 -> 2 -> 3 -> 4 -> 5, k = 3
        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 3;
        ListNode head2 = reverseKGroup.createList(arr2);
        System.out.print("原始链表: ");
        reverseKGroup.printList(head2);
        ListNode result2 = reverseKGroup.reverseKGroup(head2, k2);
        System.out.print("翻转后链表: ");
        reverseKGroup.printList(result2);

        // 测试用例 3：空链表, k = 2
        int[] arr3 = {};
        int k3 = 2;
        ListNode head3 = reverseKGroup.createList(arr3);
        System.out.print("原始链表: ");
        reverseKGroup.printList(head3);
        ListNode result3 = reverseKGroup.reverseKGroup(head3, k3);
        System.out.print("翻转后链表: ");
        reverseKGroup.printList(result3);
    }
}
