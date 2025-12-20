class Solution {

    private int findParent(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = findParent(parent[x], parent);
    }

    private void union(int a, int b, int[] rank, int[] parent){
        int parentA = findParent(a, parent);
        int parentB = findParent(b, parent);

        if(parentA == parentB) return;

        if(rank[parentA] < rank[parentB]){
            parent[parentA] = parentB;
        } else if(rank[parentB] < rank[parentA]){
            parent[parentB] = parentA;
        } else {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        // Initial secret sharing at time 0
        union(0, firstPerson, rank, parent);

        int i = 0;
        while(i < meetings.length){
            int time = meetings[i][2];
            List<Integer> cache = new ArrayList<>();

            // Process all meetings at the same timestamp
            while(i < meetings.length && meetings[i][2] == time){
                int a = meetings[i][0];
                int b = meetings[i][1];

                union(a, b, rank, parent);
                cache.add(a);
                cache.add(b);
                i++;
            }

            int root0 = findParent(0, parent);

            // Roll back nodes not connected to 0
            for(int node : cache){
                if(findParent(node, parent) != root0){
                    parent[node] = node;
                    rank[node] = 0;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        int root0 = findParent(0, parent);
        for(int j = 0; j < n; j++){
            if(findParent(j, parent) == root0){
                ans.add(j);
            }
        }

        return ans;
    }
}