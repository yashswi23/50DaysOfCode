class Solution {
    boolean [][] dp ;
    List<List<String>> res;
    public void solve(String s, int idx, List<String> curr){
        if(idx == s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j=idx;j<s.length();j++){
            if(dp[idx][j]){
            curr.add(s.substring(idx,j+1));
            solve(s,j+1,curr);
            curr.remove(curr.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
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
   res = new ArrayList<>();
   solve(s,0,new ArrayList<>());
   return res;  
    }
}