class Solution {
    public int maxSubArray(int[] nums) {
       int n = nums.length;
       int[]dp = new int[n+1];
       dp[0] = nums[0];
       int maxi=nums[0];

       for(int i=1;i<n;i++){
        dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
        maxi = Math.max(maxi,dp[i]);
       } 

       return maxi;
    }
}