class Solution {
    private int recursive(int x, int[] dp){
        if(x == 1){
            return 1;
        }

        if(x == 2){
            return 1;
        }

        if(dp[x] != -1){
            return dp[x];
        }


        int ans = 0;
        for(int i = 1; i < x; i++){
            ans = Math.max(ans, i * Math.max(x-i, recursive(x-i, dp)));
        }
        dp[x] = ans;
        return ans;
    }
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }

        return recursive(n, dp);
        
    }
}