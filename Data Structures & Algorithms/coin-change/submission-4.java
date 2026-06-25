class Solution {

    private int recursiveHelper(int[] coins, int ind, int amount, int[][] dp){
        int n = coins.length;

        if(ind == n-1){
            if((amount % coins[ind]) == 0){
                return amount/coins[ind];
            }else{
                return (int) 1e9;
            }
        }

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return (int) 1e9;
        }

        if(dp[ind][amount] != -1){
            return dp[ind][amount];
        }

        int skip = recursiveHelper(coins, ind+1, amount, dp);

        int pick = (int) 1e9;

        if(amount >= coins[ind]){
            pick = 1 + recursiveHelper(coins, ind, amount - coins[ind], dp);
        }

        dp[ind][amount] = Math.min(skip, pick);
        return dp[ind][amount];
    }

    private int recursive(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }

        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= amount; j++){
                dp[i][j] = -1;
            }
        }

        int result = recursiveHelper(coins, 0, amount, dp);
        return result >= (int) 1e9 ? -1 : result;
    }
    public int coinChange(int[] coins, int amount) {
        return recursive(coins, amount);
    }
}
