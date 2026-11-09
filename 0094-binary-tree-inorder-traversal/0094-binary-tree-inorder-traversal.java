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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        if (root == null) {
            return arr;
        }

        fun(root,arr);
        return arr;
    }

    public void fun(TreeNode root, List<Integer> arr){
        if (root.left==null && root.right==null){
            arr.add(root.val);
            return;
        }

        if (root.left!=null){
            fun(root.left,arr);
        }

        arr.add(root.val);

        if(root.right!=null){
            fun(root.right,arr);
        }
        return;
    }
}