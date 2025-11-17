class Solution {
    int n ;
    int[][]dp;
    public int solve(int[] nums, int idx, int target){
        if(idx==n) return target==0?1:0;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int not = solve(nums,idx+1,target);
        int take=0;
        if(nums[idx]<= target){
            take = solve(nums,idx+1,target-nums[idx]);
        }

        return dp[idx][target]= take+not;
    }


    public int partsum(int[] nums,int target){
        n = nums.length;
        dp = new int[n][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return  solve(nums,0,target);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int tsum=0;
        for(int num: nums){
            tsum+= num;
        }
        if((tsum+target)%2!=0) return 0;
        int tg = (tsum+target)/2;
         if (tg < 0) return 0;
        return partsum(nums,tg);
    }
}