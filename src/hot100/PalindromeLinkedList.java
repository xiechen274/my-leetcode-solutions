package hot100;

/**
 * @author xlj 2024-12-16
 */

/**
 * LeetCode 234: 回文链表
 * 题目链接: https://leetcode.cn/problems/palindrome-linked-list/
 *
 * 题目描述:
 * 给你一个单链表的头节点 head ，判断该链表是否为回文链表。
 *
 * 示例:
 * 输入: head = [1,2,2,1]
 * 输出: true
 *
 * 进阶:
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    /**
     * 静态方法，用于生成链表
     */
    static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * 打印链表
     */
    static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class PalindromeLinkedList {

    /**
     * 判断链表是否为回文链表的方法
     * @param head 链表头节点
     * @return 是否为回文链表
     */
    public static boolean isPalindrome(ListNode head) {
        int[] nodeVal = new int[1000];
        int index = 0;
        while(head != null){
            nodeVal[index] = head.val;
            index++;
            head = head.next;
        }
        for(int i = 0; i <= index ;i++){
            if(nodeVal[i] != nodeVal[index - i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] testCases = {
                {1, 2, 2, 1},
                {1, 2},
                {1},
                {1, 2, 3, 2, 1},
                {1, 2, 3, 4, 5}
        };

        boolean[] expectedOutputs = {true, false, true, true, false};

        System.out.println("运行测试用例...");

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            boolean expected = expectedOutputs[i];
            ListNode head = ListNode.createList(testCase);

            System.out.println("测试用例 " + (i + 1) + ": 输入链表 = ");
            ListNode.printList(head);

            boolean result = isPalindrome(head);

            System.out.println("预期输出: " + expected + ", 实际输出: " + result);
            System.out.println(result == expected ? "? 测试通过" : "? 测试失败");
            System.out.println("--------------------------");
        }
    }
}

