class Solution {
    List<String> ans;
    public void solve(String res, int opn, int close, int n){
        if(res.length() ==2*n){
            ans.add(res);
            return;
        }
        if(opn<n) solve(res+"(", opn+1,close,n);
        if(close< opn) solve(res+")",opn,close+1,n);
    }
    public List<String> generateParenthesis(int n) {
    ans = new ArrayList<>();
    solve("",0,0,n);
    return ans;  
    }
}