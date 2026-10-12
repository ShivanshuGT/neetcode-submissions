class Solution {
    private int recursive(int person, int idx, int m, int[] arr, int[][][] dp){
        int n = arr.length;
        if(idx >= n){
            return 0;
        }

        if(dp[person][idx][m] != -1){
            return dp[person][idx][m];
        }

        int ans = person == 1 ? -1 : Integer.MAX_VALUE;
        int sum = 0;
        for(int x = 1; x <= 2*m && (idx+x-1 < n); x++){
            sum += arr[idx+x-1];
            if(person == 1){
                ans = Math.max(ans, sum + recursive(0, idx+x, Math.max(m, x), arr, dp));
            }else{
                ans = Math.min(ans, recursive(1, idx+x, Math.max(m, x), arr, dp));
            }
        
        }
        dp[person][idx][m] = ans;
        return ans;
    }
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if(n == 1){
            return piles[0];
        }
        int[][][] dp = new int[2][n][n];
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        // 1 -> Alice
        // 0 -> Bob
        return recursive(1, 0, 1, piles, dp);
        
    }
}