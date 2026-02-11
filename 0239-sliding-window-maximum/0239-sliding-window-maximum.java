class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        int i=0;
        int j=0;
        int idx=0;
        while(j<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[j] ){
                dq.pollLast();
            }

            dq.addLast(j);
            if(dq.peekFirst()<i){
                dq.pollFirst();
            }

            if(j-i+1 == k){
                ans[idx++] = nums[dq.peekFirst()];
                i++;
            }
            j++;
           

        }

        return ans;
    }
}