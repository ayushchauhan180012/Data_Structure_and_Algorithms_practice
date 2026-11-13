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
    Stack<TreeNode> st = new Stack<>();

    public int kthSmallest(TreeNode root, int k) {
        if (root==null){
            return 0;
        }
        TreeNode t = root;
        while(t != null){
            st.push(t);
            t = t.left;
        }

        TreeNode smallest = getSmall();
        for(int i=0 ;i<k-1; i++){
            smallest = getSmall();
        }
        if (smallest==null){
            return 0;
        }
        return smallest.val;
    }

    public TreeNode getSmall(){
        if (st.empty()){
            return null;
        }

        TreeNode small = st.pop();
        TreeNode right = small.right;

        while(right!=null){
            st.push(right);
            right = right.left;
        }
        return small;
    }
}