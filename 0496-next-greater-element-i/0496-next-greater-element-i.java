class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer,Integer> mp = new HashMap<>();
        int []ans = new int[nums1.length];
        int idx=0;
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]> st.peek() ){
                mp.put(st.pop(),nums2[i]);
            }
            st.add(nums2[i]);
        }

        while(!st.isEmpty()){
            mp.put(st.pop(),-1);
        }

        for(int i=0;i<nums1.length;i++){
            ans[idx++] = mp.get(nums1[i]);
        }

        return ans;
    }
}