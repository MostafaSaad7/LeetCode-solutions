class Solution {

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr !=null || !stack.empty())
        {

            if (curr !=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            else
            {
                curr=stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }

        }


        return res;


    }


}

