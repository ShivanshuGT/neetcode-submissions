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

    private void doInorderTraversal(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        }
        
        doInorderTraversal(node.left, ans);
        ans.add(node.val);
        doInorderTraversal(node.right, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorderTraversal = new ArrayList<>();
        doInorderTraversal(root, inorderTraversal);
        return inorderTraversal.get(k-1);
    }
}
