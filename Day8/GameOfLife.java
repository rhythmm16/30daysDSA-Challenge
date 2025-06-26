class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n= board[0].length;
        int[][] mat=new int[m][n];
        int[][] move = {
    {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live=0;
                for(int[] dir:move){
                    int newi=i+dir[0];
                    int newj=j+dir[1];
                    if(newi>=0 && newi<m && newj>=0 && newj<n && board[newi][newj]==1){
                        live++;
                    }
                }
                if(board[i][j]==1){
                    if(live<2 || live>3){
                        mat[i][j]=0;
                    }
                    else{
                        mat[i][j]=1;
                    }
                }
                else{
                    if(live==3){
                        mat[i][j]=1;
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            System.arraycopy(mat[i],0,board[i],0,n);
        }

    }
}