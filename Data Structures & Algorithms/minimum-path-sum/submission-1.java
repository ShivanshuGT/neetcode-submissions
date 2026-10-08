class Solution {

    private int[][] dirs = {{1, 0}, {0, 1}};

    private int recursive(int row, int col, int[][] grid, int sum, int[][][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if(row == n-1 && col == m-1){
            return sum;
        }

        if(dp[row][col][sum] != -1){
            return dp[row][col][sum];
        }

        int ans = Integer.MAX_VALUE;

        for(int[] dir: dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            if(i >= 0 && i < n && j >= 0 && j < m){
                ans = Math.min(ans, recursive(i, j, grid, sum+grid[i][j], dp));
            }
        }
        dp[row][col][sum] = ans;
        return ans;
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sum += grid[i][j];
            }
        }

        int[][][] dp = new int[n][m][sum+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k <= sum; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return recursive(0, 0, grid, grid[0][0], dp);
        
    }
}