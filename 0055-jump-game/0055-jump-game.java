class Solution {
    public boolean canJump(int[] nums) {
        int n= nums.length;

        int maxr = 0;
        for(int i=0;i<n;i++){
            if(i> maxr){
                return false;
            }

            maxr = Math.max(maxr, i+nums[i]);
        }

        return true;
    }
}