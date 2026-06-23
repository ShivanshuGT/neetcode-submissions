class Solution {

    int helper(int[] cost, int i, int ans){
        int n = cost.length;
        if(i >= n){
            return ans;
        }

        ans += cost[i];

        int c1 = helper(cost, i+1, ans);
        int c2 = helper(cost, i+2, ans);
        return Math.min(c1, c2);
    }
    // public int minCostClimbingStairs(int[] cost) {

    //     int c1 = helper(cost, 0, 0);
    //     int c2 = helper(cost, 1, 0);
    //     return Math.min(c1, c2);
        
    // }

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int prePrev = cost[0];
        int prev = cost[1];
        int ans = 0;

        for(int i = 2; i < n; i++){
            ans = cost[i] + Math.min(prev, prePrev);
            prePrev = prev;
            prev = ans;
        }
        return Math.min(prePrev, prev);
        
    }
}
