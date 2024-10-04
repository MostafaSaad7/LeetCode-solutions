class Solution {

    Map<Integer, Integer> inorderPositions = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1 || inorder.length < 1) return null;

        for (int i = 0; i < inorder.length; i++) {
            inorderPositions.put(inorder[i], i);
        }

        return builder(preorder, 0, 0, inorder.length - 1);
    }

    public TreeNode builder(
        int[] preorder,
        int preorderIndex,
        int inorderLow,
        int inorderHigh
    ) {
        if (
            preorderIndex > preorder.length - 1 || inorderLow > inorderHigh
        ) return null;

        int currentVal = preorder[preorderIndex];
        TreeNode n = new TreeNode(currentVal);
        int mid = inorderPositions.get(currentVal);

        n.left = builder(preorder, preorderIndex + 1, inorderLow, mid - 1);
        n.right =
            builder(
                preorder,
  preorderIndex + (mid - inorderLow) + 1,  // Adjusted preorder index for right subtree
    mid + 1,  // Starting position for the right subtree in the inorder array
                inorderHigh
            );

        return n;
    }
}