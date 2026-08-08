class Solution {
    public long time(int[] arr, int k){
        long time_count = 0;
        for (int i =0; i<arr.length; i++){
            if (arr[i]%k != 0){
                time_count += arr[i] / k + 1;
            }else{
                time_count+= arr[i]/k;
            }
        }
        return time_count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for (int i = 1; i<piles.length; i++){
            if (piles[i] > high){
                high = piles[i];
            }
        }
        while(low <= high){
            int mid = (low + high)/2;
            if (time(piles,mid) > h){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}