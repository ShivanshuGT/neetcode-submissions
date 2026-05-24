class LRUCache {

    class Node{
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }

    }

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;

    private void insertNodeAfterHead(Node node){
        Node afterHead = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = afterHead;
        afterHead.prev= node;
    }

    private void deleteLeastRecentlyUsedNode(Node node){
        Node back = node.prev;
        back.next = this.tail;
        this.tail.prev = back;
    }

    public LRUCache(int capacity) {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }
    
    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            Node back = node.prev;
            Node forward = node.next;
            back.next = forward;
            forward.prev = back;
            this.insertNodeAfterHead(node);
            return node.val;
        }
        return -1;
        
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            node.val = value;
            Node back = node.prev;
            Node forward = node.next;
            back.next = forward;
            forward.prev = back;
            this.insertNodeAfterHead(node);

        }else{
            if(this.size == this.capacity){
                Node toBeDeleted = this.tail.prev;
                map.remove(toBeDeleted.key);
                this.deleteLeastRecentlyUsedNode(toBeDeleted);
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                this.insertNodeAfterHead(newNode);
            }else{
                Node newNode = new Node(key, value);
                map.put(key, newNode);
                this.insertNodeAfterHead(newNode);
                this.size += 1;
            }
        }
        
    }
}
