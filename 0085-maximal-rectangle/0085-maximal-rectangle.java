class Solution {

    public int[] NearLeft(int[] height){
        int n = height.length;
        int[] nsl = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[st.peek()]>= height[i]){
                st.pop();
            }
            nsl[i] = st.isEmpty()?-1: st.peek();
            st.push(i);
        }

        return nsl;
    }
    public int[] NearRight(int[] height){
        int n = height.length;
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>= height[i]){
                st.pop();
            }
            nsr[i] = st.isEmpty()?n: st.peek();
            st.push(i);
        }

        return nsr;
    }

    public int maximalarea(int[]height){
        int n = height.length;
        int width=0;
        int a=0;
        int maxi=0;
        int[]nsl = NearLeft(height);
        int[] nsr = NearRight(height);
        for(int i=0;i<n;i++){
            width = nsr[i]-nsl[i]-1;
            a= width* height[i];
            maxi = Math.max(maxi, a);
        }
        return maxi;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxarea =0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    height[j]+=1;
                }
                else{
                    height[j]=0;
                }
            }
            int area = maximalarea(height);
            maxarea = Math.max(maxarea,area);
        }
        return maxarea;


    }
}