class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private int recursiveHelper(int[][] matrix, int row, int col, int prev, int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;

        if(row >= n || row < 0 || col >= m || col < 0){
            return 0;
        }

        if(matrix[row][col] <= prev){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int ans = 1;
        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];
            ans  = Math.max(ans, 1 + recursiveHelper(matrix, row + dir[0], col + dir[1], matrix[row][col], dp));
            
        }
        dp[row][col] = ans;
        return ans;

    }

    private int recursive(int[][] matrix){
        int ans = Integer.MIN_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, recursiveHelper(matrix, i, j, -1, dp));
            }
        }
        return ans;

    }
    public int longestIncreasingPath(int[][] matrix) {
        return recursive(matrix);
    }
}
