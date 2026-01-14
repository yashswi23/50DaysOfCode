class Solution {
    boolean[][]dp;
    public int minCut(String s) {
         int n = s.length();
    dp = new boolean[n][n];
    for(int i=0;i<n;i++){
        dp[i][i]= true;
    }


   for(int len=2;len<=n;len++){
    for(int i=0;i+len<=n;i++){
        int j = i+len-1;

        if(s.charAt(i) == s.charAt(j)){
            if(len==2){
                dp[i][j] = true;
            }
            else{
                dp[i][j] = dp[i+1][j-1];
            }
        }

    }
   }

   int[] cuts = new int[n+1];
   Arrays.fill(cuts,Integer.MAX_VALUE);
   cuts[n]=-1;

   for(int i=n-1;i>=0;i--){
    for(int j=0;j<n;j++){
        if(dp[i][j]){
            cuts[i] = Math.min(cuts[i],1+cuts[j+1]);
        }
    }
   }

   return cuts[0];
    }
}