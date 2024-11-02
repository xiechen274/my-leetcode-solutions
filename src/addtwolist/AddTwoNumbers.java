package addtwolist;

//https://leetcode.cn/problems/add-two-numbers/
public class AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            //创建一个新的链表来存储结果
            ListNode ans = null;
            ListNode cur = null;
            int carry = 0;
            while (h1 != null || h2 != null) {
                int sum,val;
                // 处理 h1 和 h2 的当前节点逻辑
                sum = (h1.val = h1 == null ? 0 : h1.val) +
                        (h2.val = h2 == null ? 0 : h2.val);

                val = sum % 10;
                carry = sum / 10;

                if(ans == null){
                    ans = new ListNode(val);
                    cur = ans;
                }else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
            if(carry != 0){
                cur.next = new ListNode(carry);
            }
            h1 = h1 == null ? null : h1.next;
            h2 = h2 == null ? null : h2.next;
            return ans;
        }
    }

}
