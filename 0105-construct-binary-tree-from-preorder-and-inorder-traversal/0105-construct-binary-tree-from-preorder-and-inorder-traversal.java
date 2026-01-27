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
    int postIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = preorder.length;

    for(int i=0;i<inorder.length;i++){
        mp.put(inorder[i],i);
    }
    postIndex =0;

    return  solve(preorder,inorder,mp,0,inorder.length-1);

        
        
    }

    public TreeNode solve(int[] preorder, int [] inorder,Map<Integer,Integer> mp, int instart, int inend){
        if(instart> inend) return null;
        TreeNode root =  new TreeNode(preorder[postIndex++]);
        int idx = mp.get(root.val);

        root.left = solve(preorder,inorder,mp,instart, idx-1);
        root.right = solve(preorder,inorder,mp,idx+1,inend);

        return root;
    }
}