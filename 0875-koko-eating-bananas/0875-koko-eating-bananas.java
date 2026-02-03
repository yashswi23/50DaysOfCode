class Solution {

    public boolean canEat(int[] piles, int mid, int h){
        int actH=0;
        for(int x: piles){
            actH+= x/mid;
            if(x%mid!=0){
                actH++;
            }
        }

        return actH<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low=1;
        int high= 0;
        for(int x: piles){
            high = Math.max(high,x);
        }

        while(low<high){
            int mid = low+(high-low)/2;

            if(canEat(piles,mid,h)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}