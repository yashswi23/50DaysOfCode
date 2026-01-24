class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int p=0;
        int[] ans = new int[k];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)-> b[1]-a[1]);

        for(int num: nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mp.entrySet()){
          pq.add(new int[]{entry.getKey(), entry.getValue()});
        }

        while(!pq.isEmpty() && k>0){
            ans[p++] = pq.poll()[0];
            k--;
        }

        return ans;

        
    }
}