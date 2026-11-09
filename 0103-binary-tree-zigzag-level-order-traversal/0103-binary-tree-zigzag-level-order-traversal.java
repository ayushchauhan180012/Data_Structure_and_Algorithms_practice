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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean leftToRight = true;
        Queue<TreeNode> q = new ArrayDeque<>();

        if (root == null){
            return res;
        }

        q.add(root);
        while(!q.isEmpty()){
            int lvlsize = q.size();
            List<Integer> temp = new ArrayList<>(
                Collections.nCopies(lvlsize, 0)
            );
            int first = 0;
            int last = lvlsize-1;
            while(lvlsize--!=0){
                TreeNode t = q.poll();
                if (leftToRight){
                    temp.set(first, t.val);
                    first++;
                }
                else{
                    temp.set(last, t.val);
                    last--;
                }

                if (t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
            }
            res.add(temp);
            leftToRight = !leftToRight;
        }
        return res;
    }
}