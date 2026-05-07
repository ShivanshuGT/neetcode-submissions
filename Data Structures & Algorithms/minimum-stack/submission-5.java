class MinStack {

    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(this.stack.isEmpty()){
            this.min = val;

        }
        else if(this.min > val){
            if(val == Integer.MIN_VALUE){
                this.min = Integer.MIN_VALUE;
            }else{
                int encodedVal = 2*val - this.min;
                this.min = val;
                val = encodedVal;
            }
            
        }
        this.stack.push(val);
    }
    
    public void pop() {
        if(this.min == Integer.MIN_VALUE){
            this.stack.pop();
            this.min = this.stack.peek();
        }
        else{
            if(this.stack.peek() < this.min){
            System.out.println(this.stack.peek());
            this.min = 2*this.min - this.stack.peek();
            }
            this.stack.pop();
        }
    }
    
    public int top() {
        int top = this.stack.peek();
        if(top < this.min){
            top = this.min;
        }
        return top;
    }
    
    public int getMin() {
        return this.min;
    }
}
