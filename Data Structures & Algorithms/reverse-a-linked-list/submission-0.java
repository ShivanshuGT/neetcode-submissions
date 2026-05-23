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

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;
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
}
