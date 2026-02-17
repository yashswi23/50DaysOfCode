class Solution {

    public void dfs(int node, boolean[] vis, List<List<Integer>> adj){
        vis[node]=true;
        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj);
            }
        }

    }
    public int findCircleNum(int[][] isco) {
        int n=isco.length;
        int m = isco[0].length; 
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isco[i][j] == 1&& i!=j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int count=0;

        boolean[] vis = new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(i,vis,adj);
            }
        }
        return count;


    }
}