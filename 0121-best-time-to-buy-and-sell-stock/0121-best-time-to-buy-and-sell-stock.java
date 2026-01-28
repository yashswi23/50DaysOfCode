class Solution {
    public int maxProfit(int[] prices) {
    int n = prices.length;

    int minpro = prices[0];
    int maxpro=0;

    for(int i=1;i<n;i++){
        minpro = Math.min(minpro, prices[i]);

        maxpro = Math.max(maxpro, prices[i]- minpro);
    }

    return maxpro;
    }
}