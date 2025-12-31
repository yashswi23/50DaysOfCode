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
    int preIndex =-1;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }

        return solve(preorder,inorder,0,inorder.length-1,mp);
    }

    public TreeNode solve(int[] preorder,int[] inorder, int instart, int inend, Map<Integer,Integer> mp){
        if(instart> inend) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);
        int idx = mp.get(root.val);

        root.left = solve(preorder, inorder,instart, idx-1,mp);
        root.right = solve(preorder,inorder, idx+1,inend,mp);
        return root;
    }
}