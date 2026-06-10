class Solution {

    private int dirs[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private void helper(char[][] grid, int row, int col){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            helper(grid, i, j);
        }
    }
    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        char[][] mat = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                mat[i][j] = grid[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0;j < m; j++){
                if(mat[i][j] == '1'){
                    ans += 1;
                    helper(mat, i, j);
                }
            }
        }
        return ans;
        
    }
}
