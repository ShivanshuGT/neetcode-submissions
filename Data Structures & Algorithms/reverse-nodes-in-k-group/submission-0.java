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

    private ListNode findKthNode(ListNode start, int k){
        ListNode temp = start;
        k -= 1;
        while(start != null && k > 0){
            k -= 1;
            start = start.next;
        }
        return start;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        ListNode third =  null;

        head.next = null;
        while(second != null){
            third = second.next;
            second.next = first;
            first = second;
            second = third;
        }
        return first;

    }
    public ListNode reverseKGroup(ListNode head, int k) {

        
        ListNode temp = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(temp != null){
            ListNode kthNode = findKthNode(temp, k);

            if(kthNode == null){
                // we dont have k nodes in this cluster
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
                
            }else{
                nextNode = kthNode.next;
                kthNode.next = null;
                reverse(temp);

                if(temp == head){
                    // this is the first cluster
                    head = kthNode;
                }
                if(prevNode != null){
                    prevNode.next = kthNode;
                }
                
                prevNode = temp;
                temp = nextNode;
                
            }

        }
        return head;

       


        
    }
}
