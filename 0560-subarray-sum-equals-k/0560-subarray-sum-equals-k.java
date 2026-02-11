class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int count=0;
        int psum=0;
        for(int i=0;i<n;i++){
            psum+= nums[i];
            if(mp.containsKey(psum-k)){
                count+= mp.get(psum-k);
            }
            mp.put(psum,mp.getOrDefault(psum,0)+1);
        }
        return count;
    }
}