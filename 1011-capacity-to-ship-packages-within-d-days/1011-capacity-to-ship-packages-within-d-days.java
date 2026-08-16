class Solution {
    public boolean posibility(int[] weights, int days, int guess){
        int n = 1;
        int wtsum = 0;
        for(int i=0;i<weights.length;i++){
            if (wtsum + weights[i] > guess){
                n++;
                wtsum = weights[i];
            }else{
                wtsum += weights[i];
            }
            if (n > days) {
                return false;
            }
            
        }
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int res = high;
        while(low <= high){
            int guess = low + (high - low) / 2;
            
            if (posibility(weights,days, guess)){
                res = guess;
                high = guess - 1; 
            }else{
                low = guess + 1;
            }
        }
        return res;
    }
}