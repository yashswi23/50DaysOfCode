class Solution {
    int n;
    int m;
    public void dfs(int x, int y, char[][]grid ){
        if(x<0 || y<0 || x>=n || y>=m || grid[x][y]=='0') return;
        grid[x][y]='0';
        dfs(x+1,y,grid);
        dfs(x,y+1,grid);
        dfs(x-1,y,grid);
        dfs(x,y-1,grid);
    }
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
       int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
        
    }
}