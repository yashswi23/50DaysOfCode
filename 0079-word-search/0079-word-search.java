class Solution {
    int n;
    int m;

    public boolean isDFS(char[][] board, String word, int i, int j, int idx){
        if(i<0 || i>=n || j<0 || j>=m || word.charAt(idx)!= board[i][j]) return false;

        if(idx == word.length()-1) return true;
        char temp = board[i][j];
        board[i][j]='#';
        boolean found =isDFS(board,word,i+1,j,idx+1) ||
        isDFS(board,word,i-1,j,idx+1) ||
        isDFS(board,word,i,j+1,idx+1)||
        isDFS(board,word,i,j-1,idx+1);
        board[i][j] = temp;

        return found;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
            {
                if(word.charAt(0) == board[i][j] && isDFS(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
        
    }
}