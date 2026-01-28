class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int psum = 0;
        int count=0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num: nums){
            psum+= num;
            if(psum== k){
                count++;
            }

            if(mp.containsKey(psum-k)){
                count+= mp.get(psum-k);
            }

            mp.put(psum,mp.getOrDefault(psum,0)+1);
        }

        return count;
    }
}