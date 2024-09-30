class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>(); // Initialize stack for in-order traversal

        while (root != null || !stack.isEmpty()) { // Continue until the root is null and the stack is empty

            // Traverse to the leftmost node
            while (root != null) {
                stack.push(root); // Push current node to stack
                root = root.left; // Move to the left child
            }

            TreeNode pop = stack.pop(); // Pop the node from the stack (smallest node)
            k--; // Decrement k, since we've visited one more node
            if (k == 0) // If k becomes 0, this is the k-th smallest node
                return pop.val; // Return the value of the k-th smallest node

            if (pop.right != null) // If the node has a right child
                root = pop.right; // Move to the right child for further in-order traversal
        }

        return -1; // In case the tree has fewer than k nodes, return -1
    }
}
