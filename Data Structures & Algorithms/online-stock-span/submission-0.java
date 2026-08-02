class StockSpanner {

    private Stack<Integer> stack;

    public StockSpanner() {
        this.stack = new Stack<>();
    }
    
    public int next(int price) {

        if(this.stack.isEmpty()){
            this.stack.push(price);
            return 1;
        }

        Stack<Integer> temp = new Stack<>();
        int ans = 1;
        while(!this.stack.isEmpty() && this.stack.peek() <= price){
            temp.push(this.stack.pop());
            ans += 1;
        }

        while(!temp.isEmpty()){
            this.stack.push(temp.pop());
        }
        this.stack.push(price);
        return ans;

        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */