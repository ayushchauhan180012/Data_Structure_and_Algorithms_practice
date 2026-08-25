class Solution {
    public boolean count(int[][] matrix, int k, int guess){
        int row = matrix.length-1;
        int col = 0;
        int count = 0;
        while(row >= 0 && col <= matrix[0].length - 1){
            if (matrix[row][col] <= guess){
                count += row+1;
                col++;
            }else{
                row--;
            }
            if (count >= k){
                return true; 
            }
        }
        return false;
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        int res = -1;

        while(low <= high){
            int guess = (low + high)/2;

            if(count(matrix, k, guess)){
                res = guess;
                high = guess - 1; 
            }else{
                low = guess + 1;
            }
        }
        return res;
    }
}