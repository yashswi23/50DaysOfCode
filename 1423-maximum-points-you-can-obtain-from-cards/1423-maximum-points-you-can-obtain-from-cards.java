class Solution {
    public int maxScore(int[] arr, int k) {
      int n = arr.length;
      int tsum=0,sum=0,minsum=0;
      for(int num:arr){
        tsum+= num;
      }

      for(int i=0;i<n-k;i++){
        sum+= arr[i];
      }
      minsum=sum;

      for(int i=n-k;i<n;i++){
        sum+= arr[i]- arr[i-(n-k)];
        minsum = Math.min(minsum,sum);

      }
      return tsum-minsum;
    }
}