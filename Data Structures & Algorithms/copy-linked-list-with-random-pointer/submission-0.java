/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head ==  null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node dummyNode = new Node(-1);
        Node temp = head;
        Node newPrev = dummyNode;

        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
            newPrev.next = newNode;
            newPrev = newNode;
        }

        Node newHead = dummyNode.next;
        temp = head;
        Node newTemp = newHead;
        while(temp != null){
            if(temp.random == null){
                newTemp.random = null;
            }else{
                newTemp.random = map.get(temp.random);
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return newHead;
        
    }
}
