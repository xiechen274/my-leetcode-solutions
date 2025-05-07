package hot100;

/**
 * @author xlj
 * @date 2025-05-07
 * @description 排序链表
 */

public class SortList {


        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            // 统计链表长度
            int length = 0;
            ListNode curr = head;
            while (curr != null) {
                length++;
                curr = curr.next;
            }

            // 哑节点，用于简化合并
            ListNode dummy = new ListNode(0);
            dummy.next = head;

            // 外层循环：step 从 1 开始，每次翻倍
            for (int step = 1; step < length; step *= 2) {
                // 每次循环的起点和尾部
                ListNode prev = dummy;
                curr = dummy.next;

                // 内层循环：遍历链表，按 step 长度分割和合并
                while (curr != null) {
                    // 找到第一个子链表的起点和长度
                    ListNode left = curr;
                    ListNode right = split(left, step); // 分割出第二个子链表
                    curr = split(right, step); // 更新 curr 为下一轮的起点

                    // 合并两个子链表
                    prev.next = merge(left, right);
                    // 更新 prev 到合并后子链表的尾部
                    while (prev.next != null) {
                        prev = prev.next;
                    }
                }
            }

            return dummy.next;
        }

        // 分割链表：从 head 开始，返回长度为 step 的子链表，剩余部分断开
        private ListNode split(ListNode head, int step) {
            if (head == null) return null;

            // 前进 step-1 步，找到分割点,这点一定要注意
            for (int i = 1; i < step && head.next != null; i++) {
                head = head.next;
            }

            // 断开链表
            ListNode next = head.next;
            head.next = null;
            return next;
        }

        // 合并两个有序链表
        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            while (left != null && right != null) {
                if (left.val <= right.val) {
                    curr.next = left;
                    left = left.next;
                } else {
                    curr.next = right;
                    right = right.next;
                }
                curr = curr.next;
            }

            // 连接剩余部分
            curr.next = (left != null) ? left : right;
            return dummy.next;
        }

    // 测试代码
    public static void main(String[] args) {
        SortList solution = new SortList();

        // 测试用例 1: [4,2,1,3]
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(1);
        head1.next.next.next = new ListNode(3);
        ListNode result1 = solution.sortList(head1);
        printList(result1); // [1,2,3,4]

        // 测试用例 2: [-1,5,3,4,0]
        ListNode head2 = new ListNode(-1);
        head2.next = new ListNode(5);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(0);
        ListNode result2 = solution.sortList(head2);
        printList(result2); // [-1,0,3,4,5]
    }

    private static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

}
