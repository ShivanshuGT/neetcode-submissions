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

    private int isBalancedHelper(TreeNode root, boolean[] ans){
        if(root == null){
            return 0;
        }
        int leftHeight = isBalancedHelper(root.left, ans);
        int rightHeight = isBalancedHelper(root.right, ans);
        ans[0] = ans[0] && Math.abs(leftHeight - rightHeight) <= 1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        isBalancedHelper(root, ans);
        return ans[0];
    }
}
