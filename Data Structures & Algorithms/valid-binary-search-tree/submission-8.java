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
    private boolean isValidBSTHelper(TreeNode node, int minRange, int maxRange){
        if(node == null){
            return true;
        }

        if(!(node.val > minRange && node.val < maxRange)){
            return false;
        }

        boolean leftAns = isValidBSTHelper(node.left, minRange, node.val);
        boolean rightAns = isValidBSTHelper(node.right, node.val, maxRange);
        return leftAns && rightAns;

    }
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }
}
