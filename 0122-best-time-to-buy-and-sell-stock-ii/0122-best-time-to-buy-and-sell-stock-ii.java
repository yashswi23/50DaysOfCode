class Solution {
    int[][]dp;

    public int solve(int idx, int[] prices, int buy){
        if(idx == prices.length) return 0;

        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int pro =0;
        if(buy == 1){
            pro = Math.max(-prices[idx]+solve(idx+1,prices,0), solve(idx+1,prices,1));
        }
        else{
            pro = Math.max(prices[idx]+solve(idx+1,prices,1), solve(idx+1,prices,0));
        }

        return dp[idx][buy] = pro;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n+1][2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(0,prices,1);

    }
}