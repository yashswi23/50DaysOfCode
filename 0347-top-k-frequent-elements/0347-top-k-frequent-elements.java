class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        Map<Integer,Integer> mp = new HashMap<>();

        int[] ans = new int[k];

        for(int num: nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
            q.add(new int[]{entry.getKey(),entry.getValue()});
        }
        for(int i=0;i<k;i++){
            ans[i] = q.poll()[0];
        }

        return ans;
    }
}