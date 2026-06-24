class Solution {

    private int recursiveHelper(int[] nums, int ind, int[] dp){

        int n = nums.length;
        if(ind >= n){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int pick = nums[ind] + recursiveHelper(nums, ind+2, dp);
        int skip = 0 + recursiveHelper(nums, ind+1, dp);
        dp[ind] = Math.max(pick, skip);
        return dp[ind];

    }

    private int recursive(int[] nums){
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }

        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[n-1];

        for(int i = 0; i < n-1; i++){
            dp[i] = -1;
        }
        
        int first = recursiveHelper(Arrays.copyOfRange(nums, 0, n-1), 0, dp);
        for(int i = 0; i < n-1; i++){
            dp[i] = -1;
        }
        
        int second = recursiveHelper(Arrays.copyOfRange(nums, 1, n), 0, dp);
        return Math.max(first, second);


    }
    public int rob(int[] nums) {
        return recursive(nums);
    }
}
