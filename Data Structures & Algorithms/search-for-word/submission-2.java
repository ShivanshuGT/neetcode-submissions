class Solution {

    private boolean helper(char[][] board, int i, int j, int ind, String word){
        int n = board.length;
        int m = board[0].length;

        if(i < 0 || i >= n || j < 0 || j >= m || ind >= word.length()){
            return false;
        }

        if(board[i][j] == '*' || board[i][j] != word.charAt(ind)){
            return false;
        }

        if(board[i][j] == word.charAt(ind) && ind == word.length()-1){
            return true;
        }

    
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; 

        char temp = board[i][j];
        board[i][j] = '*';

        for(int[] dir : dirs){
            if(helper(board, i + dir[0], j + dir[1], ind+1, word)){
                return true;
            }
        }
        board[i][j] = temp;
        return false;



    }


    public boolean exist(char[][] board, String word) {

        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, i, j, 0, word)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
}
