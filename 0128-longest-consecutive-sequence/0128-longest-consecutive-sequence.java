class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();

        for(int num: nums){
            st.add(num);
        }

        int maxlen=0;
        for(int x: st){
            if(!st.contains(x-1)){
                int curr = x;
                int len=1;

                while(st.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxlen = Math.max(maxlen,len);
            }
        }

        return maxlen;
    }
}