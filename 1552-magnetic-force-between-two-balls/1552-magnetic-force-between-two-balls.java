class Solution {
    public boolean posibility(int[] arr, int m ,int k){
        int n = 1;
        int prev_pos = arr[0];
        for (int i = 1; i< arr.length; i++){
            int force = arr[i] - prev_pos;

            if (force < k){
                continue;
            }else{
                n++;
                prev_pos = arr[i];
            }
            if (n >= m){
                return true;
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 0;
        int n = position.length;
        int high = position[n-1];
        int res = -1;
        while(low <= high){
            int guess = (low + high)/2;

            if (posibility(position, m, guess)){
                res = guess;
                low = guess + 1;
            }else{
                high = guess - 1;
            }
        }
        return res;
    }
}