class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int n = prices.length;
        int ans = 0;
        for(int r = 1; r < n; r++){
            if(prices[r] < prices[l]){
                l = r;
            }else{
                ans = Math.max(ans, prices[r] - prices[l]);
            }
        }
        return ans;
    }
}
