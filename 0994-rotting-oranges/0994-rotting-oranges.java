class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]>q = new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int[] delrow={-1,0,1,0};
        int[] delcol ={0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u = curr[0];
            int v = curr[1];
            int t = curr[2];
            time = t;

            for(int i=0;i<4;i++){
                int nrow = u+delrow[i];
                int ncol = v+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    grid[nrow][ncol] =2;
                    fresh--;
                    q.add(new int[]{nrow,ncol,t+1});
                }
            }
        }

        return fresh == 0? time: -1;
    }
}