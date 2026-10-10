class Solution {

    private int recursive(int idx, int target, int total, int sum, int[] arr, int[][] dp){
        int n = arr.length;

        if(total >= target || idx >= n){
            return Math.abs(total - (sum-total));
        }

        if(dp[idx][total] != -1){
            return dp[idx][total];
        }

        int pick = recursive(idx+1, target, total+arr[idx], sum, arr, dp);
        int skip = recursive(idx+1, target, total, sum, arr, dp);
        dp[idx][total] = Math.min(pick, skip);
        return dp[idx][total];
    }
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }
        int target = (int) Math.ceil(sum/2);
        int[][] dp = new int[n][sum+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= sum; j++){
                dp[i][j] = -1;
            }
        }
        return recursive(0, target, 0, sum, stones, dp);
        
    }
}