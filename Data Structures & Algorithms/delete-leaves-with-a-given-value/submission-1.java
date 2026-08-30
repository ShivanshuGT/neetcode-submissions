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

    private TreeNode recursive(TreeNode node, int target){
        if(node == null){
            return null;
        }

        if(node.left != null){
            node.left = recursive(node.left, target);
        }
        if(node.right != null){
            node.right = recursive(node.right, target);
        }

        if(node.left == null && node.right == null && node.val == target){
            return null;
        }
        return node;
        

    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return recursive(root, target);
        
    }
}