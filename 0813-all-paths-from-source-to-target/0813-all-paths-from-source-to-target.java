class Solution {

    void dfs(int source, int[][] graph, int dest,List<List<Integer>> res, List<Integer> temp ){
        temp.add(source);

        if(source == dest){
            res.add(new ArrayList<>(temp));
        }
        else{
            for(int v: graph[source]){
                dfs(v, graph,dest,res,temp);
            }
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int source =0;
        int dest =n-1;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(source, graph, dest,res,temp);

        return res;
    }
}