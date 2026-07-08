class Solution {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean possibleToReach(int max, int row, int col, int[][] grid, int[][] visited){
        int n = grid.length;

        if(row < 0 || row >= n || col < 0 || col >= n || visited[row][col] == 1 || grid[row][col] > max){
            return false;
        }

        if(row == n-1 && col == n-1){
            return true;
        }

        visited[row][col] = 1;

        for(int[] dir : dirs){
            int i = row + dir[0];
            int j = col + dir[1];

            if(possibleToReach(max, i, j, grid, visited)){
                return true;
            }
        }
        return false;
    }
    public int swimInWater(int[][] grid) {

        // binary search on answers
        int n = grid.length;
        int left = 0;
        int right = n*n - 1;
        int ans = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            int[][] visited = new int[n][n];

            if(possibleToReach(mid, 0, 0, grid, visited)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
        
    }
}
