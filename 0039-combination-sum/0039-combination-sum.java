class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        
        return ans;
    }

    void backtrack(int[] candidates, int target, int index,
                   List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        list.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, list, ans);
        list.remove(list.size() - 1);

        backtrack(candidates, target, index + 1, list, ans);
    }
}