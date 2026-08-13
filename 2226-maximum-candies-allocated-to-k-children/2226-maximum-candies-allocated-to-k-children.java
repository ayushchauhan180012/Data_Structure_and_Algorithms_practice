class Solution {
    public boolean canGive(int[] arr, long k, long guess){
        long child = 0;

        for (int i = 0; i<arr.length; i++){
            child += arr[i]/guess;

            if (child >= k){
                return true;
            }
        }
        return false;
    }

    public int maximumCandies(int[] candies, long k) {
        long res = 0;
        long sum = candies[0];

        long low = 1;
        long high = candies[0];
        for (int i = 1; i<candies.length; i++){
            sum += candies[i];
            if (candies[i] > high){
                high = candies[i];
            } 
        }

        if (sum < k){
            return (int)res;
        }


        while(low <= high){
            long guess = (low + high)/2;
            if(canGive(candies, k , guess)){
                res = guess;
                low = guess + 1;
            }else{
                high = guess - 1;
            }
        }
        return (int)res;
    }
}