class Solution {

    private int recursiveHelper(int[] nums, int ind, int target, int sum, int[][] dp, int maxSum){
        int n = nums.length;

        if(ind == n){
            return target == sum ? 1 : 0;
        }

        if(dp[ind][sum + maxSum] != -1){
            return dp[ind][sum + maxSum];
        }

        

        int add = recursiveHelper(nums, ind+1, target, sum + nums[ind], dp, maxSum);
        int subtract = recursiveHelper(nums, ind+1, target, sum - nums[ind], dp, maxSum);
        dp[ind][sum + maxSum] =  add + subtract;
        return dp[ind][sum + maxSum];
    }

    private int recursive(int[] nums, int target){
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int[][] dp = new int[n][2*sum+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= 2*sum; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(nums, 0, target, 0, dp, sum);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return recursive(nums, target);
    }
}
