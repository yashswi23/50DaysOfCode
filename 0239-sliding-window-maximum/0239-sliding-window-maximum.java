class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        int n = nums.length;
        int arr[] = new int[n-k+1];
        int idx=0;
        Deque<Integer> dq = new ArrayDeque<>();
        while(j<n){
            while(!dq.isEmpty() && nums[dq.peekLast()]<= nums[j]){
                dq.pollLast();
            }
            dq.addLast(j);

            if(dq.peekFirst()<i){
                dq.pollFirst();
            }

            if(j-i+1 == k){
                arr[idx++] = nums[dq.peek()];
                i++;
            }
            j++;
        }

        return arr;

    }
}