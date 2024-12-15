package hot100;

import addtwolist.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xlj 2024-12-15
 */
public class getIntersectionNode {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode visitA = headA;
        while(visitA != null){
            nodeSet.add(visitA);
            visitA = visitA.next;
        }
        visitA = headB;
        while(visitA != null){
            if(nodeSet.contains(visitA)) return visitA;
            else visitA = visitA.next;
        }
        return null;
    }
}
