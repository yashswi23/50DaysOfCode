class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        int start =-1;

        int n = s.length();

        boolean[][]dp = new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j = i+len-1;

                if(i==j){
                    dp[i][j] = true;
                }
                else if(i+1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j]= (s.charAt(i) == s.charAt(j))&& dp[i+1][j-1];
                }

                if(dp[i][j]){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        start =i;
                    }
                }
            }
        }

        return s.substring(start, start+maxlen);
    }
}