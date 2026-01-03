class Solution {
    List<String> ans;

    public void solve(int idx, String s, StringBuilder sb){
        if(idx == s.length()){
            ans.add(sb.toString());
            return;
        }

        char ch = s.charAt(idx);
        if(Character.isDigit(ch)){
            sb.append(ch);
            solve(idx+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
            sb.append(Character.toLowerCase(ch));
            solve(idx+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append(Character.toUpperCase(ch));
            solve(idx+1,s,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCasePermutation(String s) {
        ans = new ArrayList<>();
        int n = s.length();

        solve(0,s,new StringBuilder());
        return ans;
        
    }
}