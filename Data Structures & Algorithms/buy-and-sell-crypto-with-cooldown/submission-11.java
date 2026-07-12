class Solution {

    private int recursiveHelper(int[] prices, int ind, int canBuy, int[][] dp){
        int n = prices.length;
        if(ind >= n){
            return 0;
        }


        if(dp[ind][canBuy] != -1){
            return dp[ind][canBuy];
        }

        if(canBuy == 1){
            dp[ind][canBuy] = 
            Math.max(-prices[ind] + recursiveHelper(prices, ind+1, 0, dp), recursiveHelper(prices, ind+1, 1, dp));
        }else{
            dp[ind][canBuy] =  
            Math.max(prices[ind] + recursiveHelper(prices, ind+2, 1, dp),
                recursiveHelper(prices, ind+1, 0, dp));
        }

        return dp[ind][canBuy];

    }

    private int recursive(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        return recursiveHelper(prices, 0, 1, dp);
    }
    public int maxProfit(int[] prices) {
        return recursive(prices);
        
    }
}
