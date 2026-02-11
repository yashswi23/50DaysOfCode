class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int n = s.length();
        int i=0;
        int j=0;
        int maxlen =0;
        while(j<n){
            char ch = s.charAt(j);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.get(ch)>1){
                char c = s.charAt(i);
                mp.put(c,mp.get(c)-1);
                if(mp.get(c)==0){
                    mp.remove(c);
                }
                i++;
            }
            maxlen = Math.max(maxlen,j-i+1);
            j++;
        }
        return maxlen;
    }
}