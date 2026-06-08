class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(queue.size() < k){
                queue.add(nums[i]);
            }else{
                if(queue.peek() < nums[i]){
                    queue.poll();
                    queue.add(nums[i]);
                }
            }
        }
        return queue.peek();
        
    }
}
