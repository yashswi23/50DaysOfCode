class Solution {
    int n;
    int m;

    public boolean isFind(int i, int j, char[][] board,String word,int idx){
        if(i<0 || i>=n || j<0 || j>=m || board[i][j]!= word.charAt(idx)) return false;

        if(idx == word.length()-1) return true;
        char temp = board[i][j];
        board[i][j]='#';
        boolean found = isFind(i+1,j,board,word,idx+1) || isFind(i-1,j,board,word,idx+1) || isFind(i,j+1,board,word,idx+1) || isFind(i,j-1,board,word,idx+1);
        board[i][j] = temp;

        return found;


    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j] && isFind(i,j,board,word,0)){
                    return true;
                }
            }
        }
        return false;
        
    }
}