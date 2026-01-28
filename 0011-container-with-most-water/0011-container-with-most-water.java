class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j=height.length-1;

        int maxa =0;
        int area=0;
        while(i<j){
            int width = j-i;
            area = Math.min(height[i],height[j]);
            maxa = Math.max(maxa,area*width);
            if(height[i]< height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxa;
    }
}