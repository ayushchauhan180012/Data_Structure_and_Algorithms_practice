class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        backtrack(candidates,target, candidates.length, 0,0,diary,res);
        return res;        
    }

    public void backtrack(int[] arr, int target, int n, int idx, int sum, List<Integer> diary, List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(diary));
            return;
        }

        if(idx == n || sum > target) {
            return;
        }

        backtrack(arr, target, n , idx+1, sum, diary, res);

        if(arr[idx] + sum <= target){
            diary.add(arr[idx]);
            sum += arr[idx];
            backtrack(arr,target,n,idx,sum,diary,res);
            diary.remove(diary.size() - 1);
            sum -= arr[idx];
        }
        return;
    }
}