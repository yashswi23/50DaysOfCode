class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int psum=0;
        for(int num: nums){
            psum+= num;
            if(mp.containsKey(psum-k)){
                count+= mp.get(psum-k);
            }
            mp.put(psum,mp.getOrDefault(psum,0)+1);
        }
        return count;
    }
}