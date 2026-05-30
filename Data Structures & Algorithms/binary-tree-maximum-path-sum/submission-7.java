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
    private int maxPathSumHelper(TreeNode root, int[] ans){
        if(root == null){
            return 0;
        }

        int leftSum = maxPathSumHelper(root.left, ans);
        int rightSum = maxPathSumHelper(root.right, ans);
        int leftSideSum = root.val + leftSum;
        int rightSideSum = root.val + rightSum;
        int totalSum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);
        ans[0] = Math.max(ans[0], totalSum);
        return Math.max(root.val, Math.max(leftSideSum, rightSideSum));

    }
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, ans);
        return ans[0];
        
    }
}
