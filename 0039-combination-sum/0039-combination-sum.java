class Solution {
    List<List<Integer>> adj;
    public void solve(int idx, int[]can, int target, List<Integer> temp){
        if(target == 0){
            adj.add(new ArrayList<>(temp));
            return;
        }

        if(idx>= can.length || target<0){
            return;
        }

        temp.add(can[idx]);
        solve(idx,can,target-can[idx],temp);
        temp.remove(temp.size()-1);

        solve(idx+1,can,target, temp);

    }
    public List<List<Integer>> combinationSum(int[] can, int target) {
        adj = new ArrayList<>();
        int n = can.length;
        solve(0,can,target,new ArrayList<>());
        return adj;

        
    }
}