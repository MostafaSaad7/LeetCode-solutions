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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        for (int sz = queue.size(); !queue.isEmpty(); sz = queue.size()) {
            int lastNodeInTheLevel = 101;
            while (sz-- != 0) {
                TreeNode curr = queue.poll();
                lastNodeInTheLevel = curr.val;
                if (curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);
            }

            result.add(lastNodeInTheLevel);
        }

        return result;
    }
}