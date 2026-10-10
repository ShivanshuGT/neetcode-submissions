class Solution {

    private int recursive(int i, int j, int[] piles, int[][] dp){
        if(i >= j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int takeI = piles[i] + Math.min(recursive(i+2, j, piles, dp), recursive(i+1, j-1, piles, dp));
        int takeJ = piles[j] + Math.min(recursive(i, j-2, piles, dp), recursive(i+1, j-1,
        piles, dp));
        dp[i][j] = Math.max(takeI, takeJ);
        return dp[i][j];
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += piles[i];
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }

        int aliceScore = recursive(0, n-1, piles, dp);
        return aliceScore > (sum/2);
        
    }
}