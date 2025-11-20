class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> {
            if(a[1] == b[1]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int count = 0;
        int first = -1;
        int second = -1;
        for(int i = 0;i<intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            if(l <= first) continue;
            else if(l > second){
                first = r -1;
                second = r;
                count += 2;
            }
            else{
                first = second;
                second = r;
                count++;
            }
        }
        return count;
    }
}