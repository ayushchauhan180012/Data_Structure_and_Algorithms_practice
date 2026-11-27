class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int res = 0;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==false && board[i][j]=='X'){
                    dfs(board,n,m,i,j,vis);
                    res++;
                }
            }
        }
        return res;
    }

    public boolean valid(int n, int m, int i, int j){
        return i<n && i>=0 && j<m && j>=0;
    }

    public void dfs(char[][] board, int n, int m, int i,int j,boolean[][] vis){
        vis[i][j]=true;

        for(int k=0;k<4;k++){
            int row = i+x[k];
            int col = j+y[k];

            if(valid(n,m,row,col) && vis[row][col]==false && board[row][col]=='X'){
                dfs(board, n,m, row, col, vis);
            }
        }
    }
}