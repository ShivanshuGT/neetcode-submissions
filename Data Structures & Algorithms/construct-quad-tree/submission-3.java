/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    private static int calcSum(int[][] grid, int rowStart, int rowEnd, int colStart,
        int colEnd){
        int ans = 0;

        for(int i = rowStart; i <= rowEnd; i++){
            for(int j = colStart; j <= colEnd; j ++){
                ans += grid[i][j];
            }
        }
        return ans;

    }

    private  Node recursive(int[][] grid, int rowStart, int rowEnd, int colStart,
        int colEnd){
        
        if(rowStart == rowEnd && colStart == colEnd){
            return new Node(grid[rowStart][colStart] == 1, true, null, null, null, null);
        }

        int sum = calcSum(grid, rowStart, rowEnd, colStart, colEnd);
        boolean isLeaf = false;
        if(sum == 0 || sum == (rowEnd-rowStart+1)*(colEnd-colStart+1)){
            isLeaf = true;
        }
        if(isLeaf){
            return new Node(sum != 0, true, null, null, null, null);
        }
        int len = (colEnd - colStart) / 2;
        Node topLeft = recursive(grid, rowStart, rowStart + len, colStart, colStart + len);
        Node topRight = recursive(grid, rowStart, rowStart + len, colStart + len + 1, colEnd);
        Node bottomLeft = recursive(grid, rowStart + len + 1, rowEnd, colStart, colStart + len);
        Node bottomRight = recursive(grid, rowStart + len + 1, rowEnd, colStart + len + 1, colEnd);
        Node node = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
        return node;
    }
    public Node construct(int[][] grid) {
        int n = grid.length - 1;
        return recursive(grid, 0, n, 0, n);
        
    }
}