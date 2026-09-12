class Solution {

    private boolean canIncludeSide(int row, int col, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        if(row >= n || row < 0 || col >= m || col < 0){
            return true;
        }

        return grid[row][col] == 0 ;

    }

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void dfs(int row, int col, int[][] grid, int[][] visited, int[] ans){
        int n = grid.length;
        int m = grid[0].length;

        if(row >= n || row < 0 || col >= m || col < 0){
            return;
        }

        if(visited[row][col] == 1 || grid[row][col] == 0){
            return;
        }

        visited[row][col] = 1;


        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];
            ans[0] += canIncludeSide(i, j, grid) ? 1 : 0;
        }


        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];
            dfs(i, j, grid, visited, ans);
        }
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[] ans = new int[1];
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                if(visited[i][j] != 1){
                    dfs(i, j, grid, visited, ans);
                }
            }
        }
        return ans[0];
        
    }
}