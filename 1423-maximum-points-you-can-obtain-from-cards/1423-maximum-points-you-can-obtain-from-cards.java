class Solution {
    public int maxScore(int[] card, int k) {
        int maxCards =0;
        int n = card.length;

        int minSum =0;
        int sum=0;
        int tsum=0;

        for(int c: card){
            tsum+=c;
        }
        for(int i=0;i<n-k;i++){
            sum+= card[i];
        }
        minSum = sum;

        for(int i=n-k;i<n;i++){
            sum+= card[i];
            sum-= card[i-(n-k)];
            minSum = Math.min(minSum,sum);
        }

        return tsum - minSum;
    }
}