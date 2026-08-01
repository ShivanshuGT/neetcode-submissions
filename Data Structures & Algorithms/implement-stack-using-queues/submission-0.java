class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        this.queue = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = this.queue.size();
        this.queue.add(x);

        for(int i = 1; i <= size; i++){
            this.queue.add(this.queue.peek());
            this.queue.poll();
        }
        
    }
    
    public int pop() {
        if(!this.queue.isEmpty()){
            return this.queue.poll();
        }else{
            return -1;
        }
    }
    
    public int top() {
        if(!this.queue.isEmpty()){
            return this.queue.peek();
        }else{
            return -1;
        } 
    }
    
    public boolean empty() {
        return this.queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */