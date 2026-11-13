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
    Stack<TreeNode> asc = new Stack<>();
    Stack<TreeNode> dec = new Stack<>();

    public boolean findTarget(TreeNode root, int k) {

        TreeNode t = root;
        while(t!=null){
            asc.push(t);
            t=t.left;
        }
        t=root;
        while(t!=null){
            dec.push(t);
            t=t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while(i!=null && j!=null && i!=j && i.val<=j.val){
            int sum = i.val + j.val;
            if(sum == k) return true;
            if(sum<k){
                i=getSmall();
            }
            else{
                j=getBig();
            }
        }
        return false;
    }

    public TreeNode getSmall(){
        if(asc.empty()){
            return null;
        }
        TreeNode small = asc.pop();
        TreeNode rightchild = small.right;
        while(rightchild!=null){
            asc.push(rightchild);
            rightchild = rightchild.left;
        }
        return small;
    }

    public TreeNode getBig(){
        if(dec.empty()){
            return null;
        }

        TreeNode big = dec.pop();
        TreeNode leftchild = big.left;
        while(leftchild!=null){
            dec.push(leftchild);
            leftchild = leftchild.right;
        }
        return big;
    }
}