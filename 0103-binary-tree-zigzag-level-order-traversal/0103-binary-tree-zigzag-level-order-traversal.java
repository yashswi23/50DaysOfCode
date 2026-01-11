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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st.add(root);
        while(!st.isEmpty() || !st2.isEmpty()){
            List<Integer> ans = new ArrayList<>();
            if(!st.isEmpty()){
                while(!st.isEmpty()){
                TreeNode  node = st.pop();
                ans.add(node.val);

                if(node.left !=null){
                    st2.add(node.left);
                }
                if(node.right!=null){
                    st2.add(node.right);
                }
                }

            }
            else{
                while(!st2.isEmpty()){
                    TreeNode curr = st2.pop();
                    ans.add(curr.val);
                    if(curr.right !=null){
                        st.add(curr.right);
                    }
                    if(curr.left!=null){
                        st.add(curr.left);
                    }
                }
                
            }
            res.add(ans);
        }
        return res;
    }
}