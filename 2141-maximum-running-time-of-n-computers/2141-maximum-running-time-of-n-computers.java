class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        Arrays.sort(batteries);
        long extra=0;
        int size=batteries.length;
        for(int i=0;i<size-n;i++) extra+=batteries[i];

        long mini=batteries[size-n];

        if(n==1) return mini+extra;
        long ind=n;

        for(int i=size-n;i<size;i++){
            long diff=batteries[i]-mini;
            if(diff==0) continue;
            else{
                if(extra>=diff*(i-(size-n))){
                    extra-=diff*(i-(size-n));
                    mini+=diff;
                    continue;
                }
                ind=i-(size-n);
                    break;
            }
        }

        extra=extra/ind;
        mini+=extra;

        return mini;
    }
}