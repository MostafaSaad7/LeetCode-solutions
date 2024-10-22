class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>(); // Min-heap to store the top k level sums
        queue.add(root);

        while (!queue.isEmpty()) {
            int sz = queue.size();
            long levelSum = 0;

            // Calculate the sum of the current level
            for (int i = 0; i < sz; i++) {
                TreeNode removedNode = queue.remove();
                levelSum += removedNode.val;
                if (removedNode.left != null) {
                    queue.add(removedNode.left);
                }
                if (removedNode.right != null) {
                    queue.add(removedNode.right);
                }
            }

            // Add the current level sum to the priority queue
            priorityQueue.add(levelSum);
            if (priorityQueue.size() > k) {
                priorityQueue.remove(); // Keep only the top k largest sums
            }
        }

        // If there are fewer than k level sums, return -1
        if (priorityQueue.size() < k) {
            return -1;
        }

        // The root of the priority queue is the k-th largest element
        return priorityQueue.peek();
    }
}
