class Solution {

    private int findWaysRecursiveHelper(int m, int n, int row, int col, int[][] dp){
        if(row < 0 || row >= m || col < 0 || col >= n){
            return 0;
        }

        if(row == m-1 && col == n-1){
            return 1;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        dp[row][col] = findWaysRecursiveHelper(m, n, row, col+1, dp) + findWaysRecursiveHelper(m, n, row+1, col, dp);
        return dp[row][col];
    }

    private int findWaysRecursive(int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return findWaysRecursiveHelper(m, n, 0, 0, dp);
    }
    public int uniquePaths(int m, int n) {
        return findWaysRecursive(m , n);
    }
}
