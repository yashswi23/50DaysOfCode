class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        long ans = 0;

        int i=0, j=0;

        while(j<n){
            while(j+1<n && prices[j] == prices[j+1] + 1) j++;

            long len = j - i + 1;
            ans += (len * (len+1))/2;
            j++;
            i=j;
        }

        return ans;
    }
}