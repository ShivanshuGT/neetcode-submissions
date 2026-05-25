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
    private ListNode mergeTwoLists(ListNode head1, ListNode head2){
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
        ListNode t1 = head1;
        ListNode t2 = head2;

        while((t1 != null) && (t2 != null)){
            if(t1.val <= t2.val){
                temp.next = t1;
                t1 = t1.next;
                temp = temp.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
                temp = temp.next;
            }
        }

        if(t1 != null){
            temp.next = t1;
        }
        if(t2 != null){
            temp.next = t2;
        }
        return dummyNode.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0){
            return null;
        }
        if(n == 1){
            return lists[0];
        }
        ListNode ans = mergeTwoLists(lists[0], lists[1]);
        int x = 2;
        while(x < n){
            ans = mergeTwoLists(ans, lists[x]);
            x += 1;
        }
        return ans;

    }
}
