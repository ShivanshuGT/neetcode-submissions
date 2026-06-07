class KthLargest {

    private PriorityQueue<Integer> queue; 
    private int size;
    private int capacity;

    public KthLargest(int k, int[] nums) {
        this.queue = new PriorityQueue<>();
        int n = nums.length;
        if(n > 0){
            nums = Arrays.stream(nums).boxed().sorted((a, b) -> b-a).mapToInt(Integer::intValue).toArray();

            // place top k elements in the queue
            int x = k;
            int y = 0;
            while(x > 0 && y < n){
                this.queue.add(nums[y]);
                y += 1;
                x -= 1;
            }
            
        }

        this.size = Math.min(n, k);
        this.capacity = k;
        

    }
    
    public int add(int val) {
        if(!this.queue.isEmpty()){
            Integer top = this.queue.peek();
            if(val >= top){
                if(this.size == this.capacity){
                    this.queue.poll();
                    this.queue.add(val);
                }else{
                    this.queue.add(val);
                    this.size += 1;
                }
            }
            return this.queue.peek();
        }else{
            this.queue.add(val);
            this.size += 1;
            return this.queue.peek();
        }
        
        
    }
}
