/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        backtrack(root,p,q);
        return ans;
    }

    public int backtrack(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return 0;
        }

        int left = backtrack(root.left,p,q);
        int right = backtrack(root.right,p,q);

        int self = 0;
        if(root==p || root==q){
            self = 1;
        }

        int total = left + self + right;

        if(total==2 && ans==null){
            ans = root;
        }

        return total;
    }
     
}