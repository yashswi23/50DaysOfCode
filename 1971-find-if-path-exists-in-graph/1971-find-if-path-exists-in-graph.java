class Solution {
    int[] parent;
    int[] rank;
    public int find(int x){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int finda = find(x);
        int findb = find(y);

        if(finda == findb) return;

        if(rank[finda] > rank[findb]){
            parent[findb] = finda;
        }
        else if(rank[findb] > rank[finda]){
            parent[finda] = findb;
        }
        else{
            parent[findb] = finda;
            rank[finda]++;
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
        parent[i] = i;
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