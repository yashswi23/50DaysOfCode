class Solution {
    int[]dp;
    int n;

    public int solve(int idx, int[]cost){
        if(idx>=n) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int cost1 = cost[idx]+ solve(idx+1,cost);
        int cost2 = cost[idx]+solve(idx+2,cost);
        return dp[idx] = Math.min(cost1,cost2);
    }
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return Math.min(solve(0,cost),solve(1,cost));
        

    }
}