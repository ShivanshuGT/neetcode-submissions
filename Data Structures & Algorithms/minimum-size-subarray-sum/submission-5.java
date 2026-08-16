class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while(right < n){
            sum += nums[right];
            while(left <= right && sum >= target){
                ans = Math.min(ans, right-left+1);
                sum -= nums[left];
                left += 1;

            }
            right += 1;

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
        
    }
}