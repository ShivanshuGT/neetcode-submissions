/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    private Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();


    public Node cloneGraph(Node n) {
        if(n == null){
            return null;
        }
        Node ans = null;
        queue.add(n);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            Node newNode = new Node(node.val);
            if(ans == null){
                ans = newNode;
            }
            List<Node> neighbors = node.neighbors;
            List<Node> ls = new ArrayList<>();
            for(Node neighbor : neighbors){
                if(!map.containsKey(neighbor.val)){
                    Node nn = new Node(neighbor.val);
                    map.put(neighbor.val, nn);
                    queue.add(neighbor);
                    ls.add(nn);
                }
            }
            node.neighbors = ls;
        }
        return ans;
        
    }
}