class Solution {

    private boolean recursiveHelper(int[] nums, int target, int ind, int[][] dp){
        int n = nums.length;
        if(target == 0){
            return true;
        }
        if(target < 0){
            return false;
        }
        if(ind == n-1){
            return target == nums[ind];
        }
        if(dp[ind][target] != -1){
            return dp[ind][target] == 1;
        }
        boolean pick = recursiveHelper(nums, target - nums[ind], ind+1, dp);
        boolean skip = recursiveHelper(nums, target, ind+1, dp);
        dp[ind][target] = pick || skip ? 1 : 0;
        return dp[ind][target] == 1;

    }

    private boolean recursive(int[] nums, int target){
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int  i = 0; i < n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(nums, target, 0, dp);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }

        if(sum % 2 == 0){
            return recursive(nums, sum/2);
        }else{
            return false;
        }
        
    }
}
