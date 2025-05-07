package hot100;


/**
 * @author xlj
 * @date 2025-05-07
 * @description 随机链表的复制
 */

public class CopyRandomList {

    // 不要提交这个类
    public static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        // 1 -> 2 -> 3 -> ...
        // 变成 : 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> ...
        Node cur = head;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }
        Node copy = null;
        cur = head;
        // 利用上面新老节点的结构关系，设置每一个新节点的random指针
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        Node ans = head.next;
        cur = head;
        // 新老链表分离 : 老链表重新连在一起，新链表重新连在一起
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        // 返回新链表的头节点
        return ans;
    }

    public static void main(String[] args) {
        CopyRandomList copyRandomList = new CopyRandomList();
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.random = node.next.next;
        node.next.random = node;
        node.next.next.random = node.next;
        copyRandomList.copyRandomList(node);

        //打印复制后的链表
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
