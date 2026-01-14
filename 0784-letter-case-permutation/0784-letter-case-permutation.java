class Solution {
    List<String> ans;
    int n;

    public void solve(String s, int idx, StringBuilder sb){
        if(idx == s.length()){
            ans.add(sb.toString());
            return;
        }

        char ch = s.charAt(idx);
        if(Character.isDigit(ch)){
            sb.append(ch);
            solve(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(Character.toUpperCase(ch));
            solve(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toLowerCase(ch));
            solve(s,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        n = s.length();
        solve(s,0,new StringBuilder());
        return ans;
    }
}