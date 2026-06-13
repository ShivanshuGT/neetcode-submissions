class Solution {

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(char[][] board, int i, int j){
        int n = board.length;
        int m = board[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || board[i][j] == 'X' || board[i][j] == '*'){
            return;
        }

        board[i][j] = '*';

        for(int[] dir : dirs){
            helper(board, i + dir[0], j + dir[1]);
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && board[i][j] == 'O' ){
                    helper(board, i, j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == '*'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }


        
    }
}
