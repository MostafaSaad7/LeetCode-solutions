public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private int postIdx;  // \U0001f448 global index

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1; // start from the last element
        return BuildBinaryTree(inorder, postorder, 0, inorder.length - 1);
    }

    TreeNode BuildBinaryTree(int[] inorder, int[] postorder, int inOrderLeft, int inOrderRight) {
        if (postIdx < 0 || inOrderLeft > inOrderRight)
            return null;

        for (int i = inOrderLeft; i <= inOrderRight; i++) {
            if (inorder[i] == postorder[postIdx]) {
                TreeNode root = new TreeNode(postorder[postIdx--]);  

                // build right first
                root.right = BuildBinaryTree(inorder, postorder, i + 1, inOrderRight);
                root.left = BuildBinaryTree(inorder, postorder, inOrderLeft, i - 1);
                return root;
            }
        }

        return null;
    }
}
