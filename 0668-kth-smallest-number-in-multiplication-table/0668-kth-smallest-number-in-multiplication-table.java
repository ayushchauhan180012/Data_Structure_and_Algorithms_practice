class Solution {
    public boolean count(int m, int n, int k, int guess){
        int count = 0;
        int y = 1;
        while(m>0 && y<=n){
            if(m*y <= guess){
                count += m;
                y++;
            }else{
                m--;
            }
            if(count >= k){
                return true;
            }
        }
        return false;
    }

    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        int res = 0;
        
        while(low <= high){
            int guess = (low + high)/2;
            if(count(m,n,k,guess)){
                res = guess;
                high = guess-1;
            }
            else{
                low = guess+1;
            }
        }
        return res;
    }
}