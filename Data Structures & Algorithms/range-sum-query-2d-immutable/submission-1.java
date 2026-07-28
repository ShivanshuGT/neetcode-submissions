class NumMatrix {

    private int[][] mat;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        this.mat = new int[n+1][m+1];

        for(int i = 0; i < n; i++){
            int prefix = 0;
            for(int j = 0; j < m; j++){
                prefix += matrix[i][j];
                this.mat[i+1][j+1] = prefix + this.mat[i][j+1];
            }
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1 += 1;
        col1 += 1;
        row2 += 1;
        col2 += 1;
        int above = this.mat[row1-1][col2];
        int left = this.mat[row2][col1-1];
        int topLeft = this.mat[row1-1][col1-1];
        return this.mat[row2][col2] - above - left + topLeft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */