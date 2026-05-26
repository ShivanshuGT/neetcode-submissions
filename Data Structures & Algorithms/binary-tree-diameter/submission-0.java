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

    private int findMaxDiameter(TreeNode root, int[] ans){

        if(root == null){
            return 0;
        }

        int leftHeight = findMaxDiameter(root.left, ans);
        int rightHeight = findMaxDiameter(root.right, ans);
        ans[0] = Math.max(ans[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);

    }
    public int diameterOfBinaryTree(TreeNode root) {

        int[] ans = new int[1];
        findMaxDiameter(root, ans);
        return ans[0];
    }
}
