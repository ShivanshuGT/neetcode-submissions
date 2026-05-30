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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "null";
        }
        StringBuilder ans = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            if(top == null){
                ans.append("null");
                ans.append(",");
                continue;
            }
            ans.append(top.val);
            ans.append(",");
            queue.offer(top.left);
            queue.offer(top.right);
        }
        ans.setLength(ans.length() - 1); // remove the exrta comma from the end
        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");

        if(input.length == 0 || "null".equals(input[0])){
            return null;
        }
        int n = input.length;

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(i < n && !queue.isEmpty()){
            TreeNode node = queue.poll();

            if(!"null".equals(input[i])){
                node.left = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.left);
            }
            i += 1;

            if(i < n && !"null".equals(input[i])){
                node.right = new TreeNode(Integer.parseInt(input[i]));
                queue.offer(node.right);
            }
            i += 1;
        }
        return root;
        
    }
}
