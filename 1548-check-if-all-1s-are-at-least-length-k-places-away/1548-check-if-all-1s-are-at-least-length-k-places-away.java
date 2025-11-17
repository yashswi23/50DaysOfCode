class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prev_idx=-1;
        //int curr_idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
            if(prev_idx!=-1&&i-prev_idx<k) return false ;
            prev_idx=i+1;
            }
        }
        return true;
        
    }
}