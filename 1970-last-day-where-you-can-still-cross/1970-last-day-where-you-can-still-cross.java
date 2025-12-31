class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length-1;
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(canCross(row, col, cells, mid)){
                ans = mid;
                left = mid+1;
            }else{
                right = mid - 1;
            }
        }
        return ans+1;
    }
    private boolean canCross(int row, int col, int[][] cells, int day){
        int[][] grid = new int[row][col];
        for(int i=0; i<=day; i++){
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];

        for(int c=0; c<col; c++){
            if(grid[0][c] == 0){
                queue.offer(new int[]{0,c});
                visited[0][c] = true;
            }
        }
        int[][] direction = {{-1, 0}, {1,0}, {0, -1}, {0,1}};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];

            if(r == row-1){
                return true;
            }

            for(int[] dir : direction){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    queue.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
}
/*
row = 3, col = 3
cells = [
    [1,2], [2,1], [3,3], [2,2], 
    [1,1], [1,3], [2,3], [3,2], [3,1]
]
*/