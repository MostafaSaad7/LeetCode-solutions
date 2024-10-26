import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

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
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = 1_000_02;
        int[] nodeLevel = new int[n];
        int[] nodeHeight = new int[n];
        int[][] maxTwoHeightsPerLevel = new int[n][2];

        // Initialize maxTwoHeightsPerLevel with default values of zero
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxTwoHeightsPerLevel[i], 0);
        }

        treePreprocessing(root, 0, nodeLevel, nodeHeight, maxTwoHeightsPerLevel);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int level = nodeLevel[queryNode];
            int height = nodeHeight[queryNode];
            int maxHeight = 0;
            int[] maxHeightsAtLevel = maxTwoHeightsPerLevel[level];
            if (height == maxHeightsAtLevel[0]) {
                maxHeight = maxHeightsAtLevel[1];
            } else {
                maxHeight = maxHeightsAtLevel[0];
            }
            result[i] = level + maxHeight - 1;
        }

        return result;
    }

    private int treePreprocessing(TreeNode root, int level, int[] nodeLevel, int[] nodeHeight, int[][] maxHeightPerLevel) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the current node
        int height = 1 + Math.max(
                treePreprocessing(root.left, level + 1, nodeLevel, nodeHeight, maxHeightPerLevel),
                treePreprocessing(root.right, level + 1, nodeLevel, nodeHeight, maxHeightPerLevel)
        );

        // Update node level and height
        nodeLevel[root.val] = level;
        nodeHeight[root.val] = height;

        // Update the two maximum heights for the current level
        int[] currentMaxHeights = maxHeightPerLevel[level];
        if (height > currentMaxHeights[0]) {
            currentMaxHeights[1] = currentMaxHeights[0];
            currentMaxHeights[0] = height;
        } else if (height > currentMaxHeights[1]) {
            currentMaxHeights[1] = height;
        }

        return height;
    }
}
