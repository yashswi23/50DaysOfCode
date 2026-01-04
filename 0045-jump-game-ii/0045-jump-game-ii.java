class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currfar = 0;
        int currEnd = 0;
        int jumps=0;
        for(int i=0;i<nums.length-1;i++){
            currfar = Math.max(currfar,nums[i]+i);
            if(i== currEnd){
                jumps++;
                currEnd = currfar;
            }
        }
        return jumps;
    }
}