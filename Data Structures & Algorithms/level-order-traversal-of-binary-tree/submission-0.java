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

    private void levelOrderHelper(TreeNode root, int order, List<List<Integer>> ans){
        if(root == null){
            return;
        }
        List<Integer> list;
        boolean found = false;
        if(ans.size() >= order+1){
            System.out.println("jfnjnf");
            list = ans.get(order);
            found = true;
        }else{
            list = new ArrayList<>();
        }

        list.add(root.val);
        if(found){
            ans.set(order, list);
        }else{
            ans.add(list);
        }
        levelOrderHelper(root.left, order+1, ans);
        levelOrderHelper(root.right, order+1, ans);

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderHelper(root, 0, ans);
        return ans;
    }
}
