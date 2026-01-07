class Solution {
     boolean[][]dp ;
    public void solve(List<List<String>> res, List<String> ans, int i,String s){
        if(i == s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }

        for(int j=i;j<s.length();j++){
            if(dp[i][j]){
                ans.add(s.substring(i,j+1));
                solve(res,ans,j+1,s);
                ans.remove(ans.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;
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

        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        solve(res,ans,0,s);
        return res;
    }
}