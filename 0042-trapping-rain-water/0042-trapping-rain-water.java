class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum=0;
       int leftmax=0,rmax=0;
       int i=0;
       int j = height.length-1;

       while(i<j){
        if(height[i]<= height[j]){
            if(height[i]>= leftmax){
                leftmax = height[i];
            }
            else{
                sum+= leftmax-height[i];
            }
            i++;
        }
        else{
            if(height[j]>= rmax){
                rmax = height[j];
            }
            else{
                sum+= rmax-height[j];
            }
            j--;
        }
       }
        return sum;
    }
}