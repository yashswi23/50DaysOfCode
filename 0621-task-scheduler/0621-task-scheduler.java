class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];
        for(char c: tasks){
            freq[c-'A']++;
        }

        int tmarks = tasks.length;
        if(n==0){
            return tmarks;
        }

        int maxfreq=0;
        int fr=0;
        int countmax=0;

        for(int f: freq){
            if(f> maxfreq)
            {
                maxfreq = f;
                countmax=1;
            }
            else if(f == maxfreq){
                countmax++;
            }
        }

        int part = (maxfreq-1)*(n+1)+countmax;

        int ans = Math.max(tmarks,part);

        return ans;
        
    }
}