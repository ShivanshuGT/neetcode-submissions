class Solution {

    private void placeQueen(int row, int col, List<String> board){
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, 'Q');
        board.set(row, sb.toString());

    }

    private void removeQueen(int row, int col, List<String> board){
        StringBuilder sb = new StringBuilder(board.get(row));
        sb.setCharAt(col, '.');
        board.set(row, sb.toString());
    }

    private boolean canPlaceQueen(int row, int col, List<String> board){
        int n = board.size();
        int i = row;
        int j = col;

        // check for backwards
        String currentRow = board.get(i);
        while(j >= 0 && j < n){
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            j -= 1;
        }

        // check for topLeft
        i = row;
        j = col;
        while(i >= 0 && j >= 0){
            currentRow = board.get(i);
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            i -= 1;
            j -= 1;
        }

        // check for bottomLeft
        i = row;
        j = col;
        while(i >= 0 && j >= 0 && i < n && j < n){
            currentRow = board.get(i);
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;


    }

    private void helper(List<String> board, List<List<String>> ans, int col){
        int n = board.size();

        if(col == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int row = 0; row < n ; row++){
            if(canPlaceQueen(row, col, board)){
                placeQueen(row, col, board);
                helper(board, ans, col+1);
                removeQueen(row, col, board);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n ; i++){
            sb.append(".");
        }

        List<String> board = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            board.add(sb.toString());
        }
        helper(board, ans, 0);
        return ans;
        
    }
}
