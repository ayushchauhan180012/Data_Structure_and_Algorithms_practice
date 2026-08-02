class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low =0;
        int high = nums.length - 1;
        int[] res = {-1, -1};

        while(low<=high){
            int mid = (low + high)/2;
            if (nums[mid]==target){
                res[0] = mid;
                high = mid - 1; 
            }
            else if (nums[mid] > target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        if (res[0] == -1) return res;

        low = res[0];
        high = nums.length - 1;

        while(low<=high){
            int mid = (low + high)/2;
            if (nums[mid] == target){
                res[1] = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return res;
    }
}