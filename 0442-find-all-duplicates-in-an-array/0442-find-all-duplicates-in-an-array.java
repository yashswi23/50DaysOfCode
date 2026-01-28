class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<>();
        for(int num: nums){
            int idx = Math.abs(num)-1;

            if(nums[idx]<0){
                res.add(Math.abs(idx+1));
            }
            nums[idx] = - nums[idx];
        }
        return res;
    }
}