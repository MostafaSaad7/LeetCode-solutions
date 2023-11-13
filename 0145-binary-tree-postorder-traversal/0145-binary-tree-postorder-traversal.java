class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        stack.push(root);
        TreeNode currNode = root;
        while (!stack.empty()) {
            currNode = stack.pop();
            if (currNode != null) {
                if (visited.contains(currNode)) {
                    list.add(currNode.val);
                } else {
                    stack.push(currNode);
                    visited.add(currNode);
                    if (currNode.right != null)
                        stack.push(currNode.right);
                    if (currNode.left!=null)
                        stack.push(currNode.left);

                }

            }


        }
        return list;

    }


}

