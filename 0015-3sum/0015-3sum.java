class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int sum=0;

        List<List<Integer>> res = new ArrayList<>();
        if(n<3) return res;
        for(int i=0;i<=n-2;i++){
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int l = i+1;
            int r = n-1;
            int target = -nums[i];
            while(l<r){
                int mid = l+(r-l)/2;
                sum = nums[l]+nums[r];
                if(sum> target){
                    r--;
                }
                else if (sum< target){
                    l++;
                }
                else{
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    while(l< r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1])r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
        
    }
}