class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: pre){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        int count=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(Integer it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                    count++;
                }
            }

        }

        if(count == n){
            return true;
        }

        return false;






    }
}