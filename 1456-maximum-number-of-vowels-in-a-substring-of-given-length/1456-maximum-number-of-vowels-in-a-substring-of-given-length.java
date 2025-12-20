class Solution {

    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
    
    public int maxVowels(String s, int k) {

        int n = s.length();
        int l=0;
        int r=0;

        int maxv=0;
        int count=0;
        while(r<n){
            if(isVowel(s.charAt(r))){
                count++;
            }
            if(r-l+1 == k){
                maxv = Math.max(maxv, count);
                if(isVowel(s.charAt(l))){
                    count--;
                }
                l++;
            }

            r++;
        }

        return maxv;
        
    }
}