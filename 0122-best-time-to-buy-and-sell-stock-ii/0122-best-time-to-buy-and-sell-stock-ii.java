class Solution {
    int[][]dp;

    public int solve(int[] prices, int idx, int buy){
        if(idx == prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;

        if(buy == 1){
            profit = Math.max(-prices[idx]+ solve(prices,idx+1,0), 0+ solve(prices,idx+1,1));
        }
        else{
            profit = Math.max(prices[idx]+ solve(prices,idx+1,1), 0+solve(prices,idx+1,0));
        }
        dp[idx][buy] = profit;
        return dp[idx][buy];
    }
    public int maxProfit(int[] prices) {
    int  n = prices.length;
    dp  = new int[n][2];

    for(int[]row:dp){
        Arrays.fill(row,-1);
    }
    return solve(prices,0,1);
    }
}