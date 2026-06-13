class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(int[][] grid, int i, int j, int val){
        int n = grid.length;
        int m = grid[0].length;

        if(i >= n || i < 0 || j >= m ||  j < 0 || grid[i][j] == -1 || grid[i][j] == 0){
            return;
        }

        if(grid[i][j] > val+1){
            grid[i][j] = val+1;

            for(int[] dir : dirs){
                helper(grid, i + dir[0], j + dir[1], grid[i][j]);
            }
        }

    } 

    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    for(int[] dir : dirs){
                        helper(grid, i + dir[0], j + dir[1], 0);
                    }
                    
                }
            }
        }

        
    }
}
