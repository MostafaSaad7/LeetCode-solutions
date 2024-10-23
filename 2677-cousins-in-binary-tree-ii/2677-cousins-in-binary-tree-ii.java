import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelSums = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            int levelSum = 0;
            while (sz-- > 0) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            levelSums.add(levelSum);
        }

        queue.offer(root);
        root.val = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                TreeNode currentNode = queue.poll();
                int siblingSum =
                        (currentNode.left != null ? currentNode.left.val : 0) +
                                (currentNode.right != null ? currentNode.right.val : 0);

                if (currentNode.left != null) {
                    currentNode.left.val = levelSums.get(level) - siblingSum;
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    currentNode.right.val = levelSums.get(level) - siblingSum;
                    queue.offer(currentNode.right);
                }


            }

            level++;
        }


        return root;

    }
}