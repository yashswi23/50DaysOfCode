class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)!= s.charAt(right)){
                return palin(s,left+1,right) || palin(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean palin(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!= s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}