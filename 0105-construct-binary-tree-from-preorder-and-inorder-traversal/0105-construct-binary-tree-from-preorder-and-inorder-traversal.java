class Solution {
    private int preIdx;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0; // start from the first element in preorder

        // Map inorder values -> indices for quick lookup
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;

        // root from preorder
        int rootVal = preorder[preIdx++];
        TreeNode root = new TreeNode(rootVal);

        // find root in inorder
        int idx = inorderIndexMap.get(rootVal);

        // left then right (because preorder is root-left-right)
        root.left = build(preorder, inLeft, idx - 1);
        root.right = build(preorder, idx + 1, inRight);

        return root;
    }
}
