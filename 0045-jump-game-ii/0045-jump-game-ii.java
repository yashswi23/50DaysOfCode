class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int currEnd=0;
        int currfar=0;
        int jump=0;

        for(int i=0;i<n-1;i++){
            currfar = Math.max(currfar,i+nums[i]);

            if(i==currEnd){
                jump++;
                currEnd = currfar;
            }
        }
        return jump;
    }
}