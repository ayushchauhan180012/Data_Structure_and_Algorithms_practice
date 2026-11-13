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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        int sum = 0;

        backtrack(root, targetSum, sum, diary, res);
        return res;
    }

    public void backtrack(TreeNode root, int target, int sum, List<Integer> diary, List<List<Integer>> res){
        if(root==null) return;

        sum += root.val;
        diary.add(root.val);

        if(root.left==null && root.right==null){
            if(sum==target){
                res.add(new ArrayList<>(diary));
            }
        }else {
            backtrack(root.left, target, sum, diary, res);
            backtrack(root.right, target, sum, diary, res);
        }

        diary.remove(diary.size() - 1);
        return;
    }
}