class Solution {
    public int maxProduct(int[] nums) {
        int maxp = nums[0];
        int minp = nums[0];
        int res= nums[0];
        int n = nums.length;

        for(int i=1;i<nums.length;i++){
            int curr = nums[i];
            int temp = Math.max(curr, Math.max(curr*maxp, curr*minp));
            minp = Math.min(curr,Math.min(curr*maxp, curr*minp));
            maxp =temp;

            res = Math.max(res,maxp);
        }

        return res;
    }
}