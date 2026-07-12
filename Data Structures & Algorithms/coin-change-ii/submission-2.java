class Solution {

    private int recursiveHelper(int[] prices, int ind, int amount, int[][] dp){
        int n = prices.length;
        if(ind == n-1){
            if(amount % prices[ind] == 0){
                return 1;
            }else{
                return 0;
            }
        }

        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }

        int pick = 0;
        if(prices[ind] <= amount){
            pick = recursiveHelper(prices, ind, amount-prices[ind], dp);
        }
        int skip = recursiveHelper(prices, ind+1, amount, dp);
        dp[ind][amount] = pick + skip;
        return dp[ind][amount];


    }

    private int recursive(int[] prices, int amount){
        int n = prices.length;
        int[][] dp = new int[n][amount+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }
        return recursiveHelper(prices, 0, amount, dp);
    }
    public int change(int amount, int[] coins) {
        return recursive(coins, amount);
        
    }
}
