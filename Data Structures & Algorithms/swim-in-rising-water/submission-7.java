class Solution {

    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int dfs(int[][] visited, int[][] grid, int row, int col, int temp, int[] ans, int[][][] dp){
        int n = grid.length;

        if(row == n-1 && col == n-1 ){
            ans[0] = Math.min(ans[0], temp);
            return ans[0];
        }

        if(dp[row][col][temp] != -1){
            return dp[row][col][temp];
        }


        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            if(i >= 0 && i < n && j >= 0 && j < n && visited[i][j] != 1){
                visited[i][j] = 1;
                ans[0] = Math.min(ans[0], dfs(visited, grid, i, j, Math.max(temp, grid[i][j]), ans, dp));
                visited[i][j] = 0;
            }
        }
        dp[row][col][temp] = ans[0];
        return dp[row][col][temp];
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        int[][][] dp = new int[n][n][n*n+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j ++){
                for(int k = 0; k<= n*n; k++){
                    dp[i][j][k] = -1;
                }
                
            }
        }
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(visited, grid, 0, 0, grid[0][0], ans, dp);
        return ans[0];
        
    }
}
