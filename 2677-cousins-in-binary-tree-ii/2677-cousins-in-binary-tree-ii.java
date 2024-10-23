import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
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
    public TreeNode replaceValueInTree(TreeNode root) {

        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int prevLevelSum = root.val;
        while (!q.isEmpty()) {
            int currentLevelSum = 0;
            int sz = q.size();
            while (sz-- > 0) {
                TreeNode treeNode = q.poll();
                treeNode.val = prevLevelSum - treeNode.val;
                int siblingSum =
                        (treeNode.left != null ? treeNode.left.val : 0) +
                                (treeNode.right != null ? treeNode.right.val : 0);
                if (treeNode.left != null) {
                    currentLevelSum += treeNode.left.val;
                    treeNode.left.val = siblingSum;

                    q.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    currentLevelSum += treeNode.right.val;
                    treeNode.right.val = siblingSum;
                    q.offer(treeNode.right);
                }
            }

            prevLevelSum = currentLevelSum;

        }

        return root;
    }
}