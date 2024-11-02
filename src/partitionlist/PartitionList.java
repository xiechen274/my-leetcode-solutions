package partitionlist;
// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/1
public class PartitionList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {};
        ListNode(int x) { val = x; }
    }

    public static class Solution {
        public ListNode partition(ListNode head, int x) {
            //左侧区域
            ListNode leftHead = null ;
            ListNode leftTail = null;
            //右侧区域
            ListNode rightHead = null;
            ListNode rightTail = null;

            while(head != null){
                if(head.val < x){
                    if(leftHead == null){
                        leftHead = new ListNode(head.val);
                        leftTail = leftHead;
                    }else {
                        leftTail.next = new ListNode(head.val);
                        leftTail = leftTail.next;
                    }
                }else {
                    if(rightHead == null){
                        rightHead = new ListNode(head.val);
                        rightTail = rightHead;
                    }else {
                        rightTail.next = new ListNode(head.val);
                        rightTail = rightTail.next;
                    }
                }
                head = head.next;
            }
            if (leftHead == null){
                return rightHead;
            }else{
                leftTail.next = rightHead;
                return leftHead;
            }
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            // 测试用例1：普通情况
            ListNode head1 = createList(new int[]{1, 4, 3, 2, 5, 2});
            ListNode result1 = solution.partition(head1, 3);
            printList(result1);  // 预期输出示例：1 -> 2 -> 2 -> 4 -> 3 -> 5

            // 测试用例2：所有节点小于x
            ListNode head2 = createList(new int[]{1, 2, 2});
            ListNode result2 = solution.partition(head2, 3);
            printList(result2);  // 预期输出示例：1 -> 2 -> 2

            // 测试用例3：所有节点大于等于x
            ListNode head3 = createList(new int[]{4, 5, 6});
            ListNode result3 = solution.partition(head3, 3);
            printList(result3);  // 预期输出示例：4 -> 5 -> 6
        }

        // 辅助方法：创建链表
        private static ListNode createList(int[] values) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            for (int value : values) {
                current.next = new ListNode(value);
                current = current.next;
            }
            return dummy.next;
        }

        // 辅助方法：打印链表
        private static void printList(ListNode head) {
            while (head != null) {
                System.out.print(head.val);
                if (head.next != null) {
                    System.out.print(" -> ");
                }
                head = head.next;
            }
            System.out.println();
        }
    }
}
