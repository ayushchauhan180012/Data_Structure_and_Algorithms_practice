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
    TreeNode prev = null;
    TreeNode g1first = null;
    TreeNode g1sec = null;
    TreeNode g2first = null;
    TreeNode g2sec = null;
    int wrong = 0;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }

        fun(root);

        if(wrong==1){
            swap(g1first, g1sec);
        }else{
            swap(g1first, g2sec);
        }

        return;
    }

    public void fun(TreeNode root){
        if(root==null){
            return;
        }

        fun(root.left);

        if(prev==null){
            prev=root;
        }else{
            if(root.val < prev.val){
                if(wrong==0){
                    g1first = prev;
                    g1sec = root;
                    wrong++;
                }
                else{
                    g2first = prev;
                    g2sec = root;
                    wrong++;
                }
            }
        }
        prev = root;

        fun(root.right);
        return;
    }
    public void swap(TreeNode one, TreeNode two){
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
        return;
    }
}