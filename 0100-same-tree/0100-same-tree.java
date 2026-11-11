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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;

        return  backtrack(p,q); 
    }

    public boolean backtrack(TreeNode a, TreeNode b){
        if(a==null && b==null){
            return true;
        }
        if(a==null || b==null) return false;
        
        if (a.val != b.val) return false;

        return backtrack(a.left, b.left) && backtrack(a.right, b.right);
    }
}