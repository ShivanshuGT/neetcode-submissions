class Solution {

    private static int[][] dirs = {{1, 0}, {0, 1}};

    private int recursive(int row, int col, int[][] grid, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;

        if(row == n-1 && col == m-1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int ans = 0;

        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            if(i < n && i >= 0 && j < m && j >= 0){
                if(grid[i][j] == 0){
                    ans += recursive(i, j, grid, dp);
                }
            }
        }
        dp[row][col] = ans;
        return ans;

        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        return recursive(0, 0, obstacleGrid, dp);
        
    }
}