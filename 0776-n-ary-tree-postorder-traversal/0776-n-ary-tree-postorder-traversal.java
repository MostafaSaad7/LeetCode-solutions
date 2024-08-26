class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }

    private void postorderHelper(Node root, List<Integer> res) {
        if (root == null)
            return;

        if (root.children != null) {
            for (Node node : root.children) {
                postorderHelper(node, res);
            }
        }
        res.add(root.val);
    }
}
