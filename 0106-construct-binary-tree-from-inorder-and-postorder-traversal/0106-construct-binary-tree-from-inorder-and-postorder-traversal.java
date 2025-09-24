import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int postIdx;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;

        // Map value -> index in inorder for O(1) lookups
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return BuildBinaryTree(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode BuildBinaryTree(int[] inorder, int[] postorder, int inLeft, int inRight) {
        if (inLeft > inRight)
            return null;

        // Root is always the current postIdx
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        // Split inorder into left/right subtrees
        int inorderIndex = inorderIndexMap.get(rootVal);

        // Build right subtree first (because postorder goes left->right->root)
        root.right = BuildBinaryTree(inorder, postorder, inorderIndex + 1, inRight);
        root.left = BuildBinaryTree(inorder, postorder, inLeft, inorderIndex - 1);

        return root;
    }
}
