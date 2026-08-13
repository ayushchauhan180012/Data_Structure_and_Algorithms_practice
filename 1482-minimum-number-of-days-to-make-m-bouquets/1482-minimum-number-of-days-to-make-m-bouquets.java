class Solution {
    public boolean canMake(int[] arr, int m, int k , int guess){
        int bouquets = 0;
        int consecutive = 0;

        for (int i=0;i<arr.length ;i++){
            if (arr[i] <= guess){
                consecutive++;
                if (consecutive == k){
                    bouquets++;
                    consecutive = 0;
                }
            }
            else{
                consecutive = 0;
            }
            if (bouquets == m){
                return true;
            }
        }
        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int res = -1;
        if (bloomDay.length < m*k){
            return -1;
        }
        int low = 0;
        int high = 0;
        for (int i = 0; i<bloomDay.length; i++){
            if (bloomDay[i] > high){
                high = bloomDay[i];
            }
            if (bloomDay[i] < low){
                low = bloomDay[i];
            }
        }

        while(low <= high){
            int mid = (low+high)/2;

            if (canMake(bloomDay, m, k, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return res;
    }
}