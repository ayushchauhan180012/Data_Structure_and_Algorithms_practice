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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        return traversal(root, subRoot);
    }

    public boolean traversal(TreeNode root, TreeNode subroot){
        if (root==null){
            return false;
        }
        if(root.val == subroot.val && backtrack(root, subroot)){
            return true;
        }

        return traversal(root.left,subroot) || traversal(root.right, subroot);
    }

    public boolean backtrack(TreeNode root, TreeNode subroot){
        if (root==null && subroot==null){
            return true;
        }

        if (root==null || subroot==null){
            return false;
        }

        if (root.val != subroot.val){
            return false;
        }

        return backtrack(root.left, subroot.left) && backtrack(root.right, subroot.right);
    }
}