class Solution {
    
    List<Integer> res= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        dfs(root);
        return res;

    }
    
    void dfs(TreeNode root)
    {
        if (root==null)
            return;
        
        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
