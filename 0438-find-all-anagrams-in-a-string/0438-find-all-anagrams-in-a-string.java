class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int k = p.length();

        Map<Character,Integer> mp  = new HashMap<>();
        for(char ch: p.toCharArray()){
        mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        int i=0;
        int j=0;
        while(j<n){
        char ch = s.charAt(j);
        if(mp.containsKey(ch)){
        mp.put(ch,mp.get(ch)-1);
        if(mp.get(ch)>=0){
        k--;
        }
        }

        while(j-i+1 == p.length()){
        if(k==0) ans.add(i);

        char c  = s.charAt(i);
        if(mp.containsKey(c)){
        mp.put(c,mp.get(c)+1);
        if(mp.get(c)>0){
        k++;
        }
        }
        i++;
        }
        j++;
        }
        return ans;



    }
}