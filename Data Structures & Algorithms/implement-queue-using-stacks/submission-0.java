class MyQueue {

    Stack<Integer> primary;
    Stack<Integer> secondary;

    public MyQueue() {
        this.primary = new Stack<>();
        this.secondary = new Stack<>();
    }
    
    public void push(int x) {
        this.primary.push(x);
    }
    
    public int pop() {
        if(this.secondary.isEmpty() && this.primary.isEmpty()){
            return -1;
        }

        if(!this.secondary.isEmpty()){
            return this.secondary.pop();
        }

        while(!this.primary.isEmpty()){
            this.secondary.push(this.primary.pop());
        }
        return this.secondary.pop();
    }
    
    public int peek() {
        if(this.secondary.isEmpty() && this.primary.isEmpty()){
            return -1;
        }

        if(!this.secondary.isEmpty()){
            return this.secondary.peek();
        }

        while(!this.primary.isEmpty()){
            this.secondary.push(this.primary.pop());
        }
        return this.secondary.peek();
    }
    
    public boolean empty() {
        return this.primary.isEmpty() && this.secondary.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */