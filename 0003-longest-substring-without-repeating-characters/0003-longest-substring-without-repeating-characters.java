class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlen=0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int i=0;
        for(int j=0;j<n;j++){
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
        }
        return maxlen;
    }
}