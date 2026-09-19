class Solution {


    private int recursive(int x, int[] dp){
        if(x == 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        if(dp[x] != -1){
            return dp[x];
        }
        int ans = (int) 1e9;
        for(int i = 1; i*i <= x; i++){
            ans = Math.min(ans, 1 + recursive(x - i*i, dp));
        }
        dp[x] = ans;
        return ans;
    }

    private int iterative(int x){
        int[] dp = new int[x+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= x; i++){ 
            int ans = (int) 1e9;
            for(int j = 1; j *j <= i; j++){
                ans = Math.min(ans, 1 + dp[i - j*j]);
            }
            dp[i] = ans;
        }
        return dp[x];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        // return recursive(n, dp);
        return iterative(n);
    }
}