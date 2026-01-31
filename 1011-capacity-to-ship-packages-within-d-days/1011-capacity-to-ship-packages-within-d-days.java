class Solution {

    public boolean canShip(int[] weights, int mid, int days){
    int use=1;
    int curr=0;
    for(int w:weights){
        if(w+curr<=mid){
            curr+=w;
        }
        else{
            use++;
            curr=w;
        }
    }
    return use<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = 0;
        int high =0;

        for(int w: weights){
            low = Math.max(low,w);
            high  +=w;
        }
        int ans=0;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(canShip(weights,mid,days)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}