class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int sum=0;
        int maxpair =0;
        Arrays.sort(nums);
        int i=0;
        int j = nums.length-1;

        while(i<=j){
            sum = nums[i]+nums[j];
            maxpair = Math.max(maxpair,sum);
            i++;
            j--;
            

        }
        return maxpair;
    }
}