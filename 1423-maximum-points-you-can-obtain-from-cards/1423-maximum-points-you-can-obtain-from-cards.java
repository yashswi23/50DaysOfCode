class Solution {
    public int maxScore(int[] card, int k) {
        int n = card.length;
        int tsum=0;
        int minsum=0;
        int sum=0;
        int msum=0;

        for(int num: card){
            tsum+=num;
        }

        for(int i=0;i<n-k;i++){
            sum+= card[i];
        }
        minsum=sum;

        for(int i=n-k;i<n;i++){
            sum+= card[i];
            sum-= card[i-(n-k)];
            minsum = Math.min(minsum,sum);
        }

        return tsum-minsum;
        
    }
}