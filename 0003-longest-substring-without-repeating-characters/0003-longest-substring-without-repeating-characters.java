class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> mp = new HashMap<>();
        int j=0;
        int maxlen=0;
        for(int i=0;i<n;i++){
            char ch  = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch,0)+1);
            while(mp.get(ch)>1){
                char c = s.charAt(j);
                mp.put(c,mp.get(c)-1);
                if(mp.get(c) == 0){
                    mp.remove(c);
                }
                j++;  
            }
         maxlen = Math.max(maxlen,i-j+1);
        }
        return maxlen;
    }
}