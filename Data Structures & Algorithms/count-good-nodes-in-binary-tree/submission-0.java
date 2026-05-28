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

    private void goodNodesHelper(TreeNode node, int[] ans, int max){
        if(node == null){
            return;
        }

        if(node.val >= max){
            ans[0] = ans[0] + 1;
        }
        goodNodesHelper(node.left, ans, Math.max(node.val, max));
        goodNodesHelper(node.right, ans, Math.max(node.val, max));

    }
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] ans = new int[1];
        ans[0] = 1;
        goodNodesHelper(root.left, ans, root.val);
        goodNodesHelper(root.right, ans, root.val);
        return ans[0];
        
    }
}
