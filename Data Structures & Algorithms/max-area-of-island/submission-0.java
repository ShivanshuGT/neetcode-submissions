class Solution {

    private static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private void helper(int[][] mat, int row, int col, int[] area){
        int n = mat.length;
        int m = mat[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || mat[row][col] == 0){
            return;
        }

        area[0] = area[0] + 1;
        mat[row][col] = 0;

        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            helper(mat, i, j, area);
        }


    }
    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                mat[i][j] = grid[i][j];
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                if(grid[i][j] == 1){
                    int[] area = new int[1];
                    helper(mat, i, j, area);
                    ans = Math.max(ans, area[0]);
                }
            }
        }

        return ans;
        
    }
}
