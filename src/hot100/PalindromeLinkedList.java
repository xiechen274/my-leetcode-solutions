package hot100;

/**
 * @author xlj 2024-12-16
 */

/**
 * LeetCode 234: ��������
 * ��Ŀ����: https://leetcode.cn/problems/palindrome-linked-list/
 *
 * ��Ŀ����:
 * ����һ���������ͷ�ڵ� head ���жϸ������Ƿ�Ϊ��������
 *
 * ʾ��:
 * ����: head = [1,2,2,1]
 * ���: true
 *
 * ����:
 * ���ܷ��� O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(){}

    /**
     * ��̬������������������
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
     * ��ӡ����
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
     * �ж������Ƿ�Ϊ��������ķ���
     * @param head ����ͷ�ڵ�
     * @return �Ƿ�Ϊ��������
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

        System.out.println("���в�������...");

        for (int i = 0; i < testCases.length; i++) {
            int[] testCase = testCases[i];
            boolean expected = expectedOutputs[i];
            ListNode head = ListNode.createList(testCase);

            System.out.println("�������� " + (i + 1) + ": �������� = ");
            ListNode.printList(head);

            boolean result = isPalindrome(head);

            System.out.println("Ԥ�����: " + expected + ", ʵ�����: " + result);
            System.out.println(result == expected ? "? ����ͨ��" : "? ����ʧ��");
            System.out.println("--------------------------");
        }
    }
}

