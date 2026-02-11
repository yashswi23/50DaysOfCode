class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        int l = 0;
        int r = n-1;

        while(l<r){
            if(s.charAt(l)!= s.charAt(r)){
                return 2;
            }
            l++;
            r--;
        }
        return 1;
    }
}