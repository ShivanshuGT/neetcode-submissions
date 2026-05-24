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

    private static int findLength(ListNode head){
        int ans = 0;
        ListNode temp = head;

        while(temp != null){
            ans += 1;
            temp = temp.next;
        }
        return ans;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int length = findLength(head);
        int ind = length - n + 1;

        if(ind == 1){
            return head.next;
        }

        int cnt = 1;
        ListNode prev = head;
        ListNode temp = head.next;

        while(temp != null){
            cnt += 1;
            if(cnt == ind){
                prev.next = temp.next;
                return head;
            }
            prev = temp;
            temp = temp.next;
            
        }
        return head;
    }
}
