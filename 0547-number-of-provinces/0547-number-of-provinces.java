class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int res = 0;

        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(isConnected, n, i, vis);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] arr, int n, int i, boolean[] vis){
    vis[i] = true;

    for(int j = 0; j < n; j++){
        if(arr[i][j] == 1 && !vis[j]){
            dfs(arr, n, j, vis);
        }
    }
}
}