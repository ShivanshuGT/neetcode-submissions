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

        recursive(node.left, ans);
        recursive(node.right, ans);
        ans.add(node.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursive(root, ans);
        return ans;
        
    }
}