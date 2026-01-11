class Solution {

    public int [] nsl(int []heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int idx=0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            ans[i] = st.isEmpty()?-1:st.peek();
            st.add(i);
        }
        return ans;
    }
    public int [] nsr(int []heights){
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int idx=0;
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            ans[i] = st.isEmpty()?n:st.peek();
            st.add(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int[] NSL = nsl(heights);
        int[] NSR = nsr(heights);

        int maxl=0;

        for(int i=0;i<heights.length;i++){
            int width = NSR[i]-NSL[i]-1;
            int area = heights[i]*width;
            maxl = Math.max(maxl,area);
        }

        return maxl;
    }
}