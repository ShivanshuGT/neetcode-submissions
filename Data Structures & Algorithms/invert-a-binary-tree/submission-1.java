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
    public TreeNode invertTree(TreeNode root) {

    if(root == null){
        return null;
    }   

    TreeNode temp = root;
    
    TreeNode store = temp.left;
    temp.left = temp.right;
    temp.right = store;
    if(temp.left != null){
        invertTree(temp.left);
    }
    if(temp.right != null){
        invertTree(temp.right);
    }
    
    return root;   
    }
}
