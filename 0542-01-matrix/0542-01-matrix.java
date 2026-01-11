class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j,0});
                    vis[i][j]=1;
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int [] delcol = {0,1,0,-1};
        int newDist = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int dist = curr[2];

            for(int i=0;i<4;i++)
            {
                int nrow = row+delrow[i];
                int ncol = col+delcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    mat[nrow][ncol] = dist+1;
                    q.add(new int[]{nrow,ncol,dist+1});
                }

            }
        }
        return mat;
    }
}