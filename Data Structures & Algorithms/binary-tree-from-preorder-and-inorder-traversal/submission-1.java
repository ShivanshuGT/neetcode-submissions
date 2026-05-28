/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    private int findIndex(int[] arr, int val){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(arr[i] == val){
                return i;
            }
        }
        return -1;
    }
    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int startPre
    , int endPre, int startIn, int endIn){

        if(endPre < startPre || endIn < startIn){
            return null;
        }


        int val = preorder[startPre];
        int ind = findIndex(inorder, val);
        int length = ind - startIn;
        TreeNode leftTree = buildTreeHelper(preorder, inorder, startPre+1, startPre + length,
                            startIn, ind-1);
        TreeNode rightTree = buildTreeHelper(preorder, inorder, startPre + length+1, endPre,
                            ind+1, endIn);
        return new TreeNode(val, leftTree, rightTree);

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if(n == 0){
            return null;
        }
        return buildTreeHelper(preorder, inorder, 0, n-1, 0, n-1);

        
    }
}
