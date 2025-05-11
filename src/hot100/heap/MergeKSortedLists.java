package hot100.heap;

import addtwolist.ListNode;

import java.util.PriorityQueue;

/**
 * @author xlj
 * @date 2025-05-11
 * @description 合并k个有序链表
 * 本题采用优先队列(堆)时间复杂度为O(nlog(k))
 */

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        //定义小根堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode item : lists) {
            if (item != null){
                queue.add(item);
            }
        }
        //如果队列全部都是空
        if(queue.isEmpty()){
            return null;
        }
        //取一个呀节点
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(!queue.isEmpty()){
            ListNode next = queue.poll();
            cur.next = next;
            if (next.next != null) {
                queue.add(next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists solution = new MergeKSortedLists();

        // 测试用例 1：两个有序链表
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode[] lists1 = {list1, list2};
        ListNode result1 = solution.mergeKLists(lists1);
        System.out.println("Test Case 1: " + result1); // 预期: 1 -> 1 -> 3 -> 4 -> 4 -> 5 -> null
    }
}
