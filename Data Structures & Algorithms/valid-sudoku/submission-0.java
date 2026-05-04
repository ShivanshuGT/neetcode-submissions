class Trio{
    int row;
    int col;
    int quadrant;

    Trio(int row, int col, int quadrant){
        this.row = row;
        this.col = col;
        this.quadrant = quadrant;
    }
}
class Solution {

    private static int getQuadrant(int row, int col){
        if(row <= 2){
            if(col <= 2){
                return 1; 
            }else if(col <= 5){
                return 2;
            }else{
                return 3;
            }
        }else if(row <= 5){
            if(col <= 2){   
                return 4;
            }else if(col <= 5){
                return 5;
            }else{
                return 6;
            }
        }else{
            if(col <= 2){
                return 7;
            }else if(col <= 5){
                return 8;
            }else{
                return 9;
            }
        }
    }
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Trio> map = new HashMap<>();
        int n = board.length;
        for(int i = 0;i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != '.'){
                    if(map.containsKey(board[i][j] - '0')){
                        // check if this is present in the same row or
                        // in the same column
                        // or in the same quadrant
                        Trio trio = map.get(board[i][j]-'0');
                        int row = trio.row;
                        int col = trio.col;
                        int quadrant = trio.quadrant;
                        if((row == i) || (col == j) || (quadrant == getQuadrant(i, j))){
                            return false;
                        }
                    }
                    map.put(board[i][j]-'0', new Trio(i, j, getQuadrant(i, j)));
                }
            }
        }
        return true;
    }
}
