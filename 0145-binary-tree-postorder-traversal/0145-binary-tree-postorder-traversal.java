class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorderHelper(node.left, result);  // Visit left subtree
        postorderHelper(node.right, result); // Visit right subtree
        result.add(node.val);                // Visit node itself
    }
}
