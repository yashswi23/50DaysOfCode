class Solution {
    int n;
    int m;
    public void solve(int[][] image, int sr, int sc, int color, int ogcolor){
        if(sr<0 || sc<0 || sr>=n || sc>=m) return ;

        if(image[sr][sc]!= ogcolor || image[sr][sc] == color) return;

        image[sr][sc] = color;
        solve(image,sr+1,sc,color,ogcolor);
        solve(image,sr-1,sc,color,ogcolor);
        solve(image,sr,sc+1,color,ogcolor);
        solve(image,sr,sc-1,color,ogcolor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogcolor = image[sr][sc];
         n = image.length;
         m = image[0].length;
        if(ogcolor!= color)
        solve(image,sr,sc,color,ogcolor);
        return image;
    }
}