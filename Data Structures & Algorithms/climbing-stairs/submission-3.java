class Solution {

    public int climbStairs(int n){
        if(n == 1){
            return 1;
        }

        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        int prev = 2;
        int prePrev = 1;
        int ans = 0;


        for(int i = 3; i<= n; i++){
            ans = prev + prePrev;
            prePrev = prev;
            prev = ans;
        }
        return ans;


    }
}
