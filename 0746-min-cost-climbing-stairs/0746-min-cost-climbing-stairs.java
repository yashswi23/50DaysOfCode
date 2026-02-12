class Solution {
    int n;
    int[]dp;

    public int solve(int[]cost, int idx){
        if(idx>= cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];

        int s1 = solve(cost,idx+1);
        int s2 = solve(cost,idx+2);

        return dp[idx] = cost[idx]+ Math.min(s1,s2);
    }
    public int minCostClimbingStairs(int[] cost) {
       n = cost.length; 
       dp = new int[n+1];

       Arrays.fill(dp,-1);
       return Math.min(solve(cost,0), solve(cost,1)); 
    }
}