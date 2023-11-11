/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return List.of();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> hashSet = new HashSet<>();
        stack.push(root);
        TreeNode currNode = root;
        while (!stack.empty()) {
            currNode = stack.peek();
            if ((currNode.left != null && !hashSet.contains(currNode.left))|| (currNode.right != null&& !hashSet.contains(currNode.right))) {
                if (currNode.right != null ) {
                    stack.push(currNode.right);
                }
                if (currNode.left != null ) {
                    stack.push(currNode.left);
                }

            } else if ((currNode.left == null || hashSet.contains(currNode.left)) && (currNode.right == null|| hashSet.contains(currNode.right))) {
                list.add(currNode.val);
                hashSet.add(stack.pop());

            }


        }
        return list;

    }

}


