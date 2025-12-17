class Solution {

    int[] parent;
    int[] rank;

    public int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int u, int y){
        int par_x = find(u);
        int par_y = find(y);

        if(par_x == par_y) return;

        if(rank[par_x]> rank[par_y]){
            parent[par_y] = par_x;
        }
        else if(rank[par_x]< rank[par_y]){
            parent[par_x] = par_y;
        }
        else{
            parent[par_x] = par_y;
            rank[par_y]++;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int []e: edges){
            int u = e[0];
            int v = e[1];

            union(u,v);
        }

        return find(source) == find(destination);
        
    }
}