class Node{
    int key;
    int value;
    Node prev;
    Node next;
    int frequency;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 0;
    }
}

class DList{
    private Node head;
    private Node tail;
    private int size;
    
    DList(){
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

    private Node getTail(){
        return this.tail;
    }

    private int getSize(){
        return this.size;
    }

    private void insertNodeAtFront(Node node){
        Node nextNode = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        nextNode.prev = node;
        node.next = nextNode;
        this.size += 1;
    }

    private void deleteNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        this.size -= 1;
    }
}
class LFUCache {

    private HashMap<Integer, Node> keyNodeMap;
    private HashMap<Integer, DList> frequencyListMap;
    private int minFrequency;
    private int size;
    private int capacity;

    public LFUCache(int capacity) {
        this.keyNodeMap = new HashMap<>();
        this.frequencyListMap = new HashMap<>();
        this.minFrequency = 0;
        this.size = 0;
        this.capacity = capacity;
        
    }

    private void moveNodeToHigherFrequencyList(Node node){
        int currentFrequency = node.frequency;

        // remove the currentNode from that frequency lsit
        DList list = this.frequencyListMap.get(currentFrequency);
        list.deleteNode(node);

        if(list.getSize() == 0 && currentFrequency == this.minFrequency){
            this.minFrequency  += 1;
        }

        int newFrequency = currentFrequency + 1;
        // add this node to the new frequency list
        DList ls = this.frequencyListMap.getOrDefault(newFrequency, new DList());
        node.frequency = newFrequency;
        ls.insertNodeAtFront(node);
        this.frequencyListMap.put(newFrequency, ls);
        this.keyNodeMap.put(node.key, node);

    }
    
    public int get(int key) {
        if(this.keyNodeMap.containsKey(key)){
            Node node = this.keyNodeMap.get(key);
            moveNodeToHigherFrequencyList(node);
            return node.value;
        }else{
            return -1;
        }
        
    }
    
    public void put(int key, int value) {
        if(this.keyNodeMap.containsKey(key)){
            Node node = this.keyNodeMap.get(key);
            node.value = value;
            this.keyNodeMap.put(key, node);
            moveNodeToHigherFrequencyList(node);
        }else{
            if(this.size == this.capacity){
                // delete the least frequently used node
                DList list = this.frequencyListMap.get(this.minFrequency);
                Node toBeDeleted = list.getTail().prev;
                list.deleteNode(toBeDeleted);
                this.keyNodeMap.remove(toBeDeleted.key);
                this.size -= 1;

            }

            Node node = new Node(key, value);
            int frequency = 1;
            this.minFrequency = 1;
            node.frequency = 1;
            this.keyNodeMap.put(key, node);
            DList ls = this.frequencyListMap.getOrDefault(1, new DList());
            ls.insertNodeAtFront(node);
            this.frequencyListMap.put(1, ls);
            this.size += 1;

        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */