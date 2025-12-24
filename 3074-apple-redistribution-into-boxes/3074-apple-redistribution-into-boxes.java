class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        Arrays.sort(capacity);
        int count =0;

        int apple_len= apple.length;
        int cap_len = capacity.length;

        int total = 0;
        for(int i=0; i<apple_len; i++){
            total= total + apple[i];

        }
        int sum=0;

        for(int i=0; i<cap_len; i++){
            
            if(sum<total){

            sum= sum+capacity[cap_len-i-1];
            count++;

            }


        }
        return count;
        
    }
}