class Solution {
    // int[][]dp;

    // public int solve(int[] prices, int idx, int buy){
    //     if(idx == prices.length) return 0;
    //     if(dp[idx][buy]!=-1) return dp[idx][buy];
    //     int profit=0;

    //     if(buy == 1){
    //         profit = Math.max(-prices[idx]+ solve(prices,idx+1,0), 0+ solve(prices,idx+1,1));
    //     }
    //     else{
    //         profit = Math.max(prices[idx]+ solve(prices,idx+1,1), 0+solve(prices,idx+1,0));
    //     }
    //     dp[idx][buy] = profit;
    //     return dp[idx][buy];
    // }
    public int maxProfit(int[] prices) {
    int  n = prices.length;
    int[][]dp  = new int[n+1][2];
    dp[n][0] = dp[n][1]=0;

    for(int i=n-1;i>=0;i--){
        for(int buy =0;buy<2;buy++){
            if(buy == 1){
                dp[i][buy] = Math.max(-prices[i]+dp[i+1][0], 0+dp[i+1][1]);

            }
            else{
                dp[i][buy] = Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
            }
        }
    }

    return dp[0][1];
    }
}