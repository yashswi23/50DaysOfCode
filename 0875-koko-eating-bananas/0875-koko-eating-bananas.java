class Solution {

    public boolean canEat(int[] piles, int mid, int h){
        int acH=0;
        for(int x: piles){
            acH+= x/mid;
            if(x%mid!=0){
                acH++;
            }
        }
        return acH<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int low = 1;
        int high =0;

        for(int p:piles){
            high = Math.max(high,p);
        }

        while(low<high){
            int mid = low+(high-low)/2;

            if(canEat(piles,mid,h)){
                high = mid;
            }
            else{
                low= mid+1;
            }
        }
        return low;
    }
}