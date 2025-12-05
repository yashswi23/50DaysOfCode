class Solution {
    Set<List<Integer>> ans;
    public void solve(int i, int[] nums,List<Integer> res){
        if(i== nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        res.add(nums[i]);
        solve(i+1,nums,res);
        res.remove(res.size()-1);
        solve(i+1,nums,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new HashSet<>();
        Arrays.sort(nums);
        solve(0,nums,new ArrayList<>());
        return new ArrayList<>(ans); 
    }
}