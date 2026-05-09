class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = m*n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int row = mid / m;
            int col = mid % m;
            int num = matrix[row][col];

            if(num < target){
                left += 1;
            }else if(num > target){
                right -= 1;
            }else{
                return true;
            }
        }
        return false;
    }
}
