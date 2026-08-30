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

    private int recursive(TreeNode node, boolean canPick, Map<TreeNode, Integer> pickDp, Map<TreeNode, Integer> skipDp){
        if(node == null){
            return 0;
        }
        if(canPick){
            if(pickDp.containsKey(node)){
                return pickDp.get(node);
            }
        }else{
            if(skipDp.containsKey(node)){
                return skipDp.get(node);
            }
        }
        int pick = Integer.MIN_VALUE;
        if(canPick){
            pick = node.val + recursive(node.left, false, pickDp, skipDp) +         recursive(node.right,false, pickDp, skipDp);
        }
        int skip = 0 + recursive(node.left, true, pickDp, skipDp) + recursive(node.right, true, pickDp, skipDp);
        int ans = Math.max(pick, skip);
        if(canPick){
            pickDp.put(node, ans);
        }else{
            skipDp.put(node, ans);
        }
        return ans;
        

    }
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> pickDp = new HashMap<>();
        Map<TreeNode, Integer> skipDP = new HashMap<>();
        return recursive(root, true, pickDp, skipDP);
    }
}