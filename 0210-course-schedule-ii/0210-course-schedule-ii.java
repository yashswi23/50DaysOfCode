class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] in = new int[n];

        for(int e[]:pre){
            int u  = e[0];
            int v  = e[1];
            adj.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        int [] ans = new int[n];
        int idx=0;

        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;

            for(Integer it: adj.get(node)){
                in[it]--;
                if(in[it] == 0){
                    q.add(it);
                }
            }
        }

        if(idx!=n) return new int[0];
        return ans;
    
    }
}