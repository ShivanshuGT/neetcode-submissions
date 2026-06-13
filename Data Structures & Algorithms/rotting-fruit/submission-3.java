class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(int[][] mat, int i, int j, int val){
        int n = mat.length;
        int m = mat[0].length;

        if(i < 0  || i >= n || j < 0 || j >= m || mat[i][j] == -1 || mat[i][j] == 0){
            return;
        }
        

        if(mat[i][j] > val+1 ){
            mat[i][j] = val + 1;

            for(int[] dir : dirs){
                int i1 = i + dir[0];
                int j1 = j + dir[1];
                helper(mat, i1, j1, mat[i][j]);
            }
        }


    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    mat[i][j] = -1;
                }else if(grid[i][j] == 2){
                    mat[i][j] = 0;
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    for(int[] dir: dirs){
                        helper(mat, i + dir[0], j + dir[1], 0);
                    }
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == Integer.MAX_VALUE){
                    return -1;
                }
                ans = Math.max(ans, mat[i][j]);
            }
        }
        return ans;
        
    }
}
