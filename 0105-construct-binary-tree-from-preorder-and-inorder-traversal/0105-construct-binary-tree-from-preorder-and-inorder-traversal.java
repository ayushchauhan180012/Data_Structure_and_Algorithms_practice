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
    HashMap<Integer,Integer> map = new HashMap<>();
    int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length-1);
        
    }

    public TreeNode build(int[] preorder, int low, int high){
        if(low > high){
            return null;
        }

        TreeNode root = new TreeNode(preorder[idx]);
        idx++;

        int id = map.get(root.val);
        root.left = build(preorder, low, id-1);
        root.right = build(preorder, id+1, high);

        return root;
    }
}