class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][]board=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,ans, n,0);
        return ans;
    }
    private void solve(char[][]board,List<List<String>>ans,int n,int row){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }


        for(int col=0;col<n;col++){
            if(issafe(board,row,col,n)){
                board[row][col]='Q';
                solve(board,ans,n,row+1);
                board[row][col]='.';
            }
            
        }
    }

    private boolean issafe(char[][]board,int row,int col,int n){
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
    return true;

    }
}