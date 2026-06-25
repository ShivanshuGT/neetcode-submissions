class Solution {

    private int recursiveHelper(int[] coins, int amount, int ind){
        int n = coins.length;

        if(ind >= n){
            if(amount > 0){
                return 1000000;
            }
            return 0;
        }

        if(amount == 0){
            return 0;
        }

        if(amount < 0){
            return 1000000;
        }


        int pick = 1 + recursiveHelper(coins, amount - coins[ind], ind);
        int skip = 0 + recursiveHelper(coins, amount, ind+1);
        return Math.min(pick, skip);
    }

    private int recursive(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        int n = coins.length;
        int result = recursiveHelper(coins, amount, 0);
        return result >= 1000000 ? -1 : result;
    }
    public int coinChange(int[] coins, int amount) {
        return recursive(coins, amount);
    }
}
