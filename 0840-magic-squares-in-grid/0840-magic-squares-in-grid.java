class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row=grid.length, col =grid[0].length, ans=0;
        if(row<3 || col<3) return ans;
        for(int i=3;i<=row;i++){
            for(int j=3;j<=col;j++){
                if(isMagicSquare(grid,i,j)) ans++;
            }
        }
        return ans;
    }

    boolean isMagicSquare(int[][] grid, int r, int c){
        if(grid[r-2][c-2] != 5) return false;
        int k, l, num;
        int[] nMap = new int[10];
        int[] rowSum=new int[3];
        int[] colSum=new int[3];
        for(int i=r-3;i<r;i++){
            k=i+3-r;
            for(int j=c-3;j<c;j++){
                l=j+3-c;
                num=grid[i][j];
                if(num>9 || nMap[num]++>0) return false;
                colSum[k] += num;
                rowSum[l] += num;
            }
        }
        for(int val:rowSum) if(val != 15) return false;
        for(int val:colSum) if(val != 15) return false;
        return grid[r-3][c-3]+grid[r-1][c-1] == grid[r-1][c-3]+grid[r-3][c-1];
    }
}