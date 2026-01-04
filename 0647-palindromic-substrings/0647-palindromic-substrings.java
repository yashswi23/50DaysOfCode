class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][]dp =new boolean[n+1][n+1];
        int count=0;

        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j = i+len-1;

                if(i==j) dp[i][j] = true;
                else if(i+1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j))&& dp[i+1][j-1];
                }

                if(dp[i][j] == true){
                    count++;
                }
            }

        }
        return count;
    }
}