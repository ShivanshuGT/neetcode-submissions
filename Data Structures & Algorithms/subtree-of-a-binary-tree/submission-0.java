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

    private boolean isSubTreeHelper(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return (p == null && q == null);
        }

        if(p.val != q.val){
            return false;
        }
        return isSubTreeHelper(p.left, q.left) && isSubTreeHelper(p.right, q.right);
    }  


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return (root == null) && (subRoot == null);
        }

        if(isSubTreeHelper(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
