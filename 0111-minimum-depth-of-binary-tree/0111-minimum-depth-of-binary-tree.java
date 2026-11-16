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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        min(root, 1);
        return min;
    }

    public void min(TreeNode root, int count){
        if(root==null) return;
        if(root.left==null && root.right==null){
            min = Math.min(min, count);
            return;
        }

        min(root.left, count+1);
        min(root.right, count+1);

        return;
    }
}