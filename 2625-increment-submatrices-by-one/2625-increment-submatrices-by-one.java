class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans = new int[n][n];

        int[] flat = Arrays.stream(queries)
                   .flatMapToInt(arr -> Arrays.stream(arr))
                   .toArray();

        for(int i = 0; i < flat.length; i += 4){
            int row1 = flat[i];
            int col1 = flat[i+1]; 
            int row2 = flat[i+2];
            int col2 = flat[i+3];
            
            // Increment all cells in the submatrix from (row1,col1) to (row2,col2)
            for(int r = row1; r <= row2; r++){
                for(int c = col1; c <= col2; c++){
                    ans[r][c] += 1;
                }
            }
        }
        return ans;
    }
}