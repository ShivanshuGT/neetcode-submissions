class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int jumps = 0;
        int maxRange = 0;

        while(right < n-1){
            for(int i = left; i <= right; i++){
                maxRange = Math.max(maxRange, i + nums[i]);
            }
            jumps += 1;
            left = right + 1;
            right = maxRange;
        }
        return jumps;
        
    }
}
