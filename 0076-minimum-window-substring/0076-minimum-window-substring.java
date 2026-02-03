class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int maxlen = Integer.MAX_VALUE;
        int k = m;
        int start =-1;

        Map<Character,Integer> mp = new HashMap<>();
        for(char ch: t.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }

        int j=0;
        int i=0;
        while(j<n){
            char c = s.charAt(j);
            if(mp.containsKey(c)  && mp.get(c)>0){
                k--;
            }
            mp.put(c,mp.getOrDefault(c,0)-1);
            while(k==0){
                int currlen = j-i+1;
                if(maxlen > currlen){
                    maxlen = currlen;
                    start = i;
                }

                char ch = s.charAt(i);
                 mp.put(ch,mp.getOrDefault(ch,0)+1);
                if(mp.containsKey(ch) && mp.get(ch)>0){
                    k++;
                }
               
                i++;
            }
            j++;
        }
        return maxlen == Integer.MAX_VALUE?"": s.substring(start,start+maxlen);
    }
}