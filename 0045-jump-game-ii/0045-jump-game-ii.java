class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currEnd =0;
        int currFar = 0;
        int jumps =0;

        for(int i=0;i<n-1;i++){
            currFar = Math.max(currFar, nums[i]+i);
            if(i== currEnd){
                jumps++;
                currEnd = currFar;
            }
        }

        return jumps;
    }
}