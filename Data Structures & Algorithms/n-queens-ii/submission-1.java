class Solution {

    private void placeQueen(int row, int col, List<String> board){
        StringBuilder currentRow = new StringBuilder(board.get(row));
        currentRow.setCharAt(col, 'Q');
        board.set(row, currentRow.toString());

    }

    private void removeQueen(int row, int col, List<String> board){
        StringBuilder currentRow = new StringBuilder(board.get(row));
        currentRow.setCharAt(col, '.');
        board.set(row, currentRow.toString());

    }
    private boolean canPlaceQueen(int row, int col, List<String> board){
        int n = board.size();

        // checking backwards
        int j = col;
        String currentRow = board.get(row);
        while(j >= 0){
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            j -= 1;
        }

        // checking topleft
        int i = row;
        j = col;

        while(i >= 0 && j >= 0){
            currentRow = board.get(i);
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            j -= 1;
            i -= 1;
        }

        // checking bottomleft
        i = row;
        j = col;

        while(i >= 0 && i < n && j >= 0 && j < n){
            currentRow = board.get(i);
            if(currentRow.charAt(j) == 'Q'){
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }

    private void recursive(List<String> board, int[] ans, int col){
        int n = board.size();

        if(col == n){
            ans[0] += 1;
            return;
        }

        for(int row = 0; row < n; row++){
            if(canPlaceQueen(row, col, board)){
                placeQueen(row, col, board);
                recursive(board, ans, col+1);
                removeQueen(row, col, board);
            }
        }
    }
    public int totalNQueens(int n) {
        // List<List<String>> ans = new ArrayList<>();
        int[] ans = new int[1];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            sb.append(".");
        }

        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            board.add(sb.toString());
        }
        recursive(board, ans, 0);
        // return ans.size(); 
        return ans[0];       
    }
}