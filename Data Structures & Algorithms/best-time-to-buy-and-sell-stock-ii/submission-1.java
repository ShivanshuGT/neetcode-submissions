class Solution {

    private int recursiveHelper(int[] prices, int ind, int buy, int[][] dp){
        int n = prices.length;

        if(ind == n){
            return 0;
        }

        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }

        if(buy == 1){
            int take = -prices[ind] + recursiveHelper(prices, ind+1, 0, dp);
            int notTake = 0 + recursiveHelper(prices, ind+1, 1, dp);
            dp[ind][buy] =  Math.max(take, notTake);

        }else{

            int sell = prices[ind] + recursiveHelper(prices, ind+1, 1, dp);
            int notSell = 0 + recursiveHelper(prices, ind+1, 0, dp);
            dp[ind][buy] =  Math.max(sell, notSell);

        }
        return dp[ind][buy];

    }

    private int recursive(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n ; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return recursiveHelper(prices, 0, 1, dp);
    }
    public int maxProfit(int[] prices) {
        return recursive(prices);
    }
}