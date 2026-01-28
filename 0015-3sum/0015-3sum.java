class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if(n<3){
            return res;
        }

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = n-1;
            int target = -nums[i];

            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum > target){
                    right--;
                }
                else if(sum< target){
                    left++;
                }
                else{
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left<right && nums[left] == nums[left+1]) left++;
                    while(left<right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}