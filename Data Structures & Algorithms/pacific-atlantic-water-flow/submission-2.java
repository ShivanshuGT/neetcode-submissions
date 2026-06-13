class Solution {

    private boolean validCell(int n, int m , int i, int j){
        return !(i < 0 || i >= n || j < 0 || j >= m);
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(int[][] heights, int[][] mat, int i, int j){
        int n = heights.length;
        int m = heights[0].length;

        // if(mat[i][j] > 10){
        //     return;
        // }

        for(int[] dir : dirs){
            int i1 = i + dir[0];
            int j1 = j + dir[1];

            if(validCell(n, m, i1, j1) && mat[i1][j1] < 10 && heights[i1][j1] >= heights[i][j]){
                if(mat[i1][j1] != mat[i][j]){
                    mat[i1][j1] += mat[i][j];
                    helper(heights, mat, i1, j1);
                }
                
            }
        }
   
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        int[][] mat = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0){
                    mat[i][j] += 3;
                }

                if(i == n-1 || j == m-1){
                    mat[i][j] += 7;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(mat[i][j] + " ");

            }
            System.out.println();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                helper(heights, mat, i, j);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] >= 10){
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;

        
    }
}
