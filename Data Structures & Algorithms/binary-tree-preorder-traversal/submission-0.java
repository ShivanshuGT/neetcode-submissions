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
    private static void recursive(TreeNode node, List<Integer> ans){
        if(node == null){
            return;
        } 

        ans.add(node.val);
        recursive(node.left, ans);
        recursive(node.right, ans);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursive(root, ans);
        return ans;
        
    }
}