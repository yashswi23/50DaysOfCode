class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j=n-1;
        int maxa=0;

        while(i<j){
            int width = j-i;
            int area = Math.min(height[i],height[j]);
            maxa = Math.max(maxa,area*width);

            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }

        }

        return maxa;
    }
}