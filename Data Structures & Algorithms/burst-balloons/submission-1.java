class Solution {

    private int recursiveHelper(List<Integer> nums, int start, int end, int[][] dp){
        if(start > end){
            return 0;
        }

        if(dp[start][end] != -1){
            return dp[start][end];
        }

        int ans = Integer.MIN_VALUE;

        for(int i = start; i <= end; i++){
            int val = nums.get(start-1) * nums.get(i) * nums.get(end+1); 
            int left = recursiveHelper(nums, start, i-1, dp);
            int right = recursiveHelper(nums, i+1, end, dp);
            ans = Math.max(ans, val + left + right);
        }

        dp[start][end] =  ans;
        return ans;
    }
    private int recursive(int[] nums){
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            ls.add(nums[i]);
        }
        ls.add(0, 1);
        ls.add(1);
        return recursiveHelper(ls, 1, n, dp);
    }
    public int maxCoins(int[] nums) {
        return recursive(nums);
    }
}
