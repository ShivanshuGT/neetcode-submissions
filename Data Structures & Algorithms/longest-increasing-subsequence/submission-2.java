class Solution {

    private int recursiveHelper(int[] nums, int ind, int lastPicked, int[][] dp){
        int n = nums.length;
        if(ind == 0){
            if(lastPicked == n){
                return 1;
            }else{
                return nums[ind] < nums[lastPicked] ? 1 : 0;
            }
        }

        if(dp[ind][lastPicked] != Integer.MIN_VALUE){
            return dp[ind][lastPicked];
        }
        int skip  = 0 + recursiveHelper(nums, ind-1, lastPicked, dp);
        int pick = -(int) 1e9;
        if(lastPicked == n || nums[ind] < nums[lastPicked]){
            pick = 1 + recursiveHelper(nums, ind-1, ind, dp);
        }
        
        dp[ind][lastPicked] = Math.max(skip, pick);
        return dp[ind][lastPicked];
    }

    private int recursive(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return recursiveHelper(nums, n-1, n, dp);
    }
    public int lengthOfLIS(int[] nums) {
        return recursive(nums);
    }
}
