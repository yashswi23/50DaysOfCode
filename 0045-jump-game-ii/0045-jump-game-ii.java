class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currfar = 0;
        int currend =0;
        int jumps=0;
        for(int i=0;i<n-1;i++){
            currfar = Math.max(currfar,i+nums[i]);
            if(i== currend){
                jumps++;
                currend = currfar;
            }
        }
        return jumps;
        
    }
}