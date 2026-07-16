class Solution {

    private void traverseFirstRow(int[][] matrix, int row, int startCol, int endCol, List<Integer> ans){
        while(startCol <= endCol){
            ans.add(matrix[row][startCol]);
            startCol += 1;
        }
    }

    private void traverseEndCol(int[][] matrix, int col, int startRow, int endRow, List<Integer> ans){
        while(startRow <= endRow){
            ans.add(matrix[startRow][col]);
            startRow += 1;
        }
    }

    private void travserLastRow(int[][] matrix, int row, int endCol, int startCol, List<Integer> ans){
        while(endCol >= startCol){
            ans.add(matrix[row][endCol]);
            endCol -= 1;
        }
    }

    private void traverseFirstCol(int[][] matrix, int col, int endRow, int startRow, List<Integer> ans){
        while(endRow >= startRow){
            ans.add(matrix[endRow][col]);
            endRow -= 1;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int startRow = 0;
        int endRow = n-1;

        int startCol = 0;
        int endCol = m-1;

        List<Integer> ans = new ArrayList<>();

        while(startRow < n && endRow >= 0 && startCol < m && endCol >= 0){
            traverseFirstRow(matrix, startRow, startCol, endCol, ans);
            if(ans.size() == m*n){
                break;
            }
            startRow += 1;
            traverseEndCol(matrix, endCol, startRow, endRow, ans);
            if(ans.size() == m*n){
                break;
            }
            endCol -= 1;
            travserLastRow(matrix, endRow, endCol, startCol, ans);
            if(ans.size() == m*n){
                break;
            }
            endRow -= 1;
            traverseFirstCol(matrix, startCol, endRow, startRow, ans);
            if(ans.size() == m*n){
                break;
            }
            startCol += 1;
        }
        return ans;
        
    }
}
