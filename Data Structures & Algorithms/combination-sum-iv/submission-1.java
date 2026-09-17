class Solution {
    private int recursive(int idx, int[] nums, int target, int[][] dp){
        int n = nums.length;

        if(target == 0){
            return 1;
        }

        if(target < 0){
            return 0;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int ans = 0;

        for(int i = 0; i< n; i++){
            ans += recursive(i, nums, target - nums[i], dp);
        }
        dp[idx][target] = ans;
        return ans;
    }
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= target; j++){
                dp[i][j] = -1;
            }
        }
        return recursive(0, nums, target, dp);

        
    }
}