class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m = nums2.length;
        Stack<Integer> st = new Stack<>();


        int[] ans = new int[n];
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]> st.peek()){
                mp.put(st.pop(), nums2[i]);
            }
            st.add(nums2[i]);
        }

        while(!st.isEmpty()){
            mp.put(st.pop(),-1);
        }
        for(int i=0;i<nums1.length;i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}