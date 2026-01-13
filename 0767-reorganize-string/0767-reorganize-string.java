class Solution {
    public String reorganizeString(String s) {
        if(s.length()== 0) return "";

        int[] freq = new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                pq.add(new int[]{i,freq[i]});
            }
        }

        StringBuilder sb= new StringBuilder();

        while(pq.size()>1){
            int[] f = pq.poll();
            int[] sp = pq.poll();
            sb.append((char)(f[0]+'a'));
            sb.append((char)(sp[0]+'a'));
            if(--f[1]>0) pq.add(f);
            if(--sp[1]>0) pq.add(sp);
        }

        while(!pq.isEmpty()){
            if(pq.peek()[1]>1) return "";
            sb.append((char)(pq.poll()[0]+'a'));
        }

        return sb.toString();
    }
}