class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
    }
}
class MyCircularQueue {

    private int capacity;
    private int size;
    private Node head;
    private Node tail;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        
    }
    
    public boolean enQueue(int value) {
        if(this.size < this.capacity){
            Node node = new Node(value);
            Node secondLast = this.tail.prev;
            secondLast.next = node;
            node.prev = secondLast;
            node.next = this.tail;
            this.tail.prev = node;
            this.size += 1;
            return true;
        }
        return false;
        
    }
    
    public boolean deQueue() {
        if(this.size == 0){
            return false;
        }
        Node toBeRemoved = this.head.next;
        Node nextNode = toBeRemoved.next;
        this.head.next = nextNode;
        nextNode.prev = this.head;
        this.size -= 1;
        return true;

        
    }
    
    public int Front() {
        if(this.size == 0){
            return -1;
        }
        return this.head.next.data;
        
    }
    
    public int Rear() {
        if(this.size == 0){
            return -1;
        }
        return this.tail.prev.data;
        
    }
    
    public boolean isEmpty() {
        return this.size == 0;
        
    }
    
    public boolean isFull() {
        return this.size == this.capacity;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */