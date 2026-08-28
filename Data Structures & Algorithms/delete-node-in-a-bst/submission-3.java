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

    private static TreeNode findParentOfTarget(TreeNode root, int key){
        TreeNode prev = null;
        TreeNode temp = root;

        while(temp != null){
            if(temp.val == key){
                return prev;
            }else if(temp.val > key){
                prev = temp;
                temp = temp.left;
            }else{
                prev = temp;
                temp = temp.right;
            }
        }
        return null;
    }


    private static TreeNode findRightMost(TreeNode node){
        TreeNode temp = node;

        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    private static TreeNode deleteHelper(TreeNode target){
        if(target.left == null){
            return target.right;
        }else if(target.right == null){
            return target.left;
        }else{
            TreeNode rightMostChildOfLeftSubtree = findRightMost(target.left);
            rightMostChildOfLeftSubtree.right = target.right;
            return target.left;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null){
            return null;
        }

        if(root.val == key){
            return deleteHelper(root);
        }

        TreeNode parentOfTarget = findParentOfTarget(root, key);
        if(parentOfTarget == null){
            return root;
        }

        if(parentOfTarget.left != null && parentOfTarget.left.val == key){
            parentOfTarget.left = deleteHelper(parentOfTarget.left);
        }else{
            parentOfTarget.right = deleteHelper(parentOfTarget.right);
        }
        return root;
        
    }
}