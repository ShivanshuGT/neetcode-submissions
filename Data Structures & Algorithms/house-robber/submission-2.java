class Solution {

    int helper(int[] nums, int ind, int val){
        int n = nums.length;

        if(ind >= n){
            return val;
        }

        int pick = helper(nums, ind+2, val + nums[ind]);
        int skip = helper(nums, ind+1, val);
        return Math.max(pick, skip);
    }
    // public int rob(int[] nums) {
    //     return helper(nums, 0, 0);
    // }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

}
