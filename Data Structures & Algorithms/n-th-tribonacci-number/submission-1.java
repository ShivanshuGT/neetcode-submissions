class Solution {
    private int recursive(int idx, int[] dp){

        if(dp[idx] != -1){
            return dp[idx];
        }

        dp[idx] = recursive(idx-1, dp) + recursive(idx-2, dp) + recursive(idx-3, dp);
        return dp[idx];
    }
    public int tribonacci(int n) {
        if(n == 0){
            return 0;
        }

        if(n <= 2){
            return 1;
        }
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        return recursive(n, dp);
        
    }
}