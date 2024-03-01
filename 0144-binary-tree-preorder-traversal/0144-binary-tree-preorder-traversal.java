class Solution {
    
    List<Integer> res= new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr!=null || !stack.empty())
        {
            if (curr!=null)
            {
                res.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }
            else
            {
                curr=stack.pop();
                curr=curr.right;
                
            }
        }
        
        return res;

    }
}

