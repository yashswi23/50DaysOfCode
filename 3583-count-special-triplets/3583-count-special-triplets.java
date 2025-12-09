class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> after = new HashMap<>();
        Map<Integer, Integer> before = new HashMap<>();
        int mod = 1000000007;

        for(int i = 0; i < nums.length; i++){
            after.put(nums[i], after.getOrDefault(nums[i], 0) + 1);
        }

        //System.out.println(after);
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int x = 2 * nums[i];

            if(before.containsKey(x) && after.containsKey(x)){
                int left = before.get(x);
                int right = after.get(x);
                if(left > 0 && right > 0){
                    if(nums[i] == 0)
                        count = count % mod + ((long)(left % mod) * (long)((right - 1) % mod)) % mod;
                    else
                        count = count % mod + ((long)(left % mod) * (long)(right % mod)) % mod;    
                }
            }

            before.put(nums[i], before.getOrDefault(nums[i], 0) + 1);
            after.put(nums[i], after.getOrDefault(nums[i], 0) - 1);

        }

        return (int)count % mod;
    }
}