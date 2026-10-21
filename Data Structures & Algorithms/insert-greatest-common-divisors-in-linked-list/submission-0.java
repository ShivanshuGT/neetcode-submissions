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

    private static int gcd(int n1, int n2){
        while(n2 != 0){
            int rem = n1 % n2;
            n1 = n2;
            n2 = rem;
        }
        return Math.abs(n1);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode cur = head;
        ListNode fw = head.next;

        while(cur != null && fw != null){
            ListNode newNode = new ListNode(gcd(cur.val, fw.val));
            cur.next = newNode;
            newNode.next = fw;
            cur = fw;
            fw = fw.next;
        }
        return head;
        
    }
}