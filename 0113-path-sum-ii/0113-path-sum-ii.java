/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res;

    public void solve(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;
        path.add(root.val);
        if(root.left == null && root.right == null && sum== root.val){
            res.add(new ArrayList<>(path));
        }
        if(root.left != null) solve(root.left,sum-root.val,path);
        if(root.right != null) solve(root.right,sum-root.val,path);

        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }

        solve(root,targetSum, new ArrayList<>());
        return res;
        
    }
}