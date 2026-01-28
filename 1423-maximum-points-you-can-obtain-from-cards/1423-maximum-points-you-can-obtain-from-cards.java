class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int tsum=0;
        int n = cardPoints.length;
        int minsum =0;
        int sum=0;
        for(int num: cardPoints){
            tsum+= num;
        }

        for(int i=0;i<n-k;i++){
            sum+= cardPoints[i];
        }
        minsum=sum;

        for(int i=n-k;i<n;i++){
            sum+= cardPoints[i];
            sum-= cardPoints[i-(n-k)];
            minsum = Math.min(minsum, sum);
        }

        return tsum-minsum;
    }
}