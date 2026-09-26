class Solution {

    private int recursive(int idx, int[] arr, int[] dp){
        int n = arr.length;

        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        int result = Integer.MIN_VALUE;

        result = Math.max(result, arr[idx] - recursive(idx+1, arr, dp));

        if(idx+1 < n){
            result = Math.max(result, arr[idx] + arr[idx + 1] - recursive(idx+2, arr, dp));
        }

        if(idx+2 < n){
            result = Math.max(result, arr[idx] + arr[idx+1] + arr[idx+2] - recursive(idx+3, arr, dp));
        }

        dp[idx] = result;
        return result;


    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++){
            dp[i] = -1;
        }
        int diff = recursive(0, stoneValue, dp);
        if(diff > 0){
            return "Alice";
        }else if(diff < 0){
            return "Bob";
        }
        return "Tie";
        
    }
}