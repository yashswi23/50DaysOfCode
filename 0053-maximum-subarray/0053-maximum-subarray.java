class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int currSum = 0;
       int maxSum = nums[0];
       int i=0;
       while(i<n){
        currSum+= nums[i];
        maxSum = Math.max(currSum,maxSum);

        if(currSum<0){
            currSum =0;
        }
        i++;
       } 

       return maxSum;
    }
}