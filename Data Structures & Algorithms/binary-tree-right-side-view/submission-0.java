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

    private List<List<Integer>> getLevelOrderTraversal(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int times = queue.size();
            List<Integer> list = new ArrayList<>();
            while(times > 0){
                TreeNode top = queue.peek();
                if(top.left != null){
                    queue.offer(top.left);
                }
                if(top.right != null){
                    queue.offer(top.right);
                }
                list.add(top.val);
                queue.poll();
                times -= 1;
            }
            ans.add(list);
        }
        return ans;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> levelOrderTraversal = getLevelOrderTraversal(root);
        for(List<Integer> list : levelOrderTraversal){
            ans.add(list.get(list.size()-1));
        }
        return ans;
    }
}
