class Solution {

    int helper(int[] cost, int i, int ans){
        int n = cost.length;
        if(i >= n){
            return ans;
        }

        ans += cost[i];

        int c1 = helper(cost, i+1, ans);
        int c2 = helper(cost, i+2, ans);
        return Math.min(c1, c2);
    }
    // public int minCostClimbingStairs(int[] cost) {

    //     int c1 = helper(cost, 0, 0);
    //     int c2 = helper(cost, 1, 0);
    //     return Math.min(c1, c2);
        
    // }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
        
    }
}
