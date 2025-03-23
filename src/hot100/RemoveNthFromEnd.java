package hot100;

/**
 * 删除倒数n个节点
 */
public class RemoveNthFromEnd{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //记录节点数，节点数大于等于1
        int count = 1;
        ListNode countNode = head;
        while(countNode.next != null){
            count++;
            countNode = countNode.next;
        }
        // 如果只有一个元素，且要删除倒数第 n 个（n 必然为 1），返回空链表
        if (count == 1) {
            return null;
        }
        //如果删除的是第一个节点
        if(n == count){
            return head.next;
        }
        ListNode curNode = head;
        int tarIndex = 1;
        //当循环到达删除节点的前一个节点
        while(tarIndex != (count - n)){
            tarIndex++;
            curNode = curNode.next;
        }
        curNode.next = curNode.next.next != null ? curNode.next.next :null;
        return head;
    }
}
