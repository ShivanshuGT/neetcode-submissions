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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        if(left == 1){
            ListNode filler = null;
            ListNode temp = head;
            ListNode first = head;
            while(left <= right){
                ListNode nextNode = temp.next;
                temp.next = filler;
                filler = temp;
                temp = nextNode;
                left += 1;
            }
            first.next = temp;
            return filler;
        }else{
            ListNode temp = head;
            ListNode prev = temp;
            int count = 1;
            while(count < left){
                prev = temp;
                temp = temp.next;
                count += 1;
            }
            ListNode filler = null;
            ListNode first = temp;
            while(left <= right){
                ListNode nextNode = temp.next;
                temp.next = filler;
                filler = temp;
                temp = nextNode;
                left += 1;
            }
            prev.next = filler;
            first.next = temp;
            return head;
            


        }
        
    }
}