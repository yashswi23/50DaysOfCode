class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int len = sb.length();
            if(len>0 && sb.charAt(len-1) == s.charAt(i)){
                sb.deleteCharAt(len-1);
            }
            else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}