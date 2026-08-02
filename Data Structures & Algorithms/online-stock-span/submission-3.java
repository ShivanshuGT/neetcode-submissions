class StockSpanner {

    private List<Integer> ls;

    public StockSpanner() {
        this.ls = new ArrayList<>();
    }
    
    public int next(int price) {

        if(this.ls.size() == 0){
            this.ls.add(price);
            return 1;
        }

        int ans = 1;
        int last = this.ls.size()-1;
        int x = last;

        while(x >= 0 && ls.get(x) <= price){
            x -= 1;
            ans += 1;
        }
        this.ls.add(price);
        return ans;

        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */