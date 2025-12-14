class Solution {
    public int numberOfWays(String corridor) {
    final long MOD = 1_000_000_007;
     long seat=0,plant=0,total=0,ans=1;
     for(int i=0;i<corridor.length();i++){
        char c=corridor.charAt(i);
        if(c=='S'){
            seat++;
            total++;
            if(seat==3){
                ans=ans*(plant+1)% MOD;
                seat=1;
                plant=0;
            }

        }
        else if(c=='P'){
            if(seat==2) plant++;
        }
     }
     if(total %2==1 ||total==0) return 0;
     return(int )ans;
    }
}