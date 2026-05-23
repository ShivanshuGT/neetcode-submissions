/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
private static ListNode findMid(ListNode head){
    ListNode slow = head;
    ListNode fast = head;
    while(fast!=null && fast.next!=null){
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}

private static ListNode reverse(ListNode head){
    if(head == null || head.next == null){
        return head;
    }
    ListNode first = head;
    ListNode second = head.next;
    ListNode third = null;

    

    while(second != null){
        third = second.next;
        second.next = first;
        first = second;
        second = third;
    }
    head.next = null;
    return first;
}
class Solution {
    public void reorderList(ListNode head) {
        if(head== null || head.next == null || head.next.next == null){
            return;
        }

        ListNode slow = head.next;
        ListNode fast = head.next;
        ListNode prevMidNode = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prevMidNode = slow;
            slow = slow.next;
        }
        ListNode midNode = slow;
        prevMidNode.next = null;
        System.out.println(midNode.val);

        ListNode temp1 = head.next;
        ListNode temp2 = reverse(midNode);
        ListNode temp = head;

        while((temp1 != null) && (temp2 != null)){
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
            temp.next = temp1;
            temp1 = temp1.next;
            temp = temp.next;
            
        }
        if(temp1 != null){
            temp.next = temp1;
        }
        if(temp2 != null){
            temp.next = temp2;
        }


    }
}
