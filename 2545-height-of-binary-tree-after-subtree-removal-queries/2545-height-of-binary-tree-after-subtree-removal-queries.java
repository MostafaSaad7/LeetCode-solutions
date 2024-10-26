import java.util.ArrayList;
import java.util.List;

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
        List<Integer> nodeLevel = new ArrayList<>(n);
        List<Integer> nodeHeight = new ArrayList<>(n);
        List<List<Integer>> maxTwoHeightsPerLevel = new ArrayList<>(n);

        // Initialize lists with default values
        for (int i = 0; i < n; i++) {
            nodeLevel.add(0);
            nodeHeight.add(0);
            maxTwoHeightsPerLevel.add(new ArrayList<>(List.of(0, 0)));
        }

        treePreprocessing(root, 0, nodeLevel, nodeHeight, maxTwoHeightsPerLevel);

        List<Integer> result = new ArrayList<>();
        for (int queryNode : queries) {
            int level = nodeLevel.get(queryNode);
            int height = nodeHeight.get(queryNode);
            int maxHeight = 0;
            List<Integer> maxHeightsAtLevel = maxTwoHeightsPerLevel.get(level);
            if (height == maxHeightsAtLevel.get(0)) {
                maxHeight = maxHeightsAtLevel.get(1);
            } else {
                maxHeight = maxHeightsAtLevel.get(0);
            }
            result.add(level + maxHeight - 1);
        }

        // Convert List<Integer> to int[]
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int treePreprocessing(TreeNode root, int level, List<Integer> nodeLevel, List<Integer> nodeHeight, List<List<Integer>> maxHeightPerLevel) {
        if (root == null) {
            return 0;
        }

        // Calculate the height of the current node
        int height = 1 + Math.max(
                treePreprocessing(root.left, level + 1, nodeLevel, nodeHeight, maxHeightPerLevel),
                treePreprocessing(root.right, level + 1, nodeLevel, nodeHeight, maxHeightPerLevel)
        );

        // Update node level and height
        nodeLevel.set(root.val, level);
        nodeHeight.set(root.val, height);

        // Update the two maximum heights for the current level
        List<Integer> currentMaxHeights = maxHeightPerLevel.get(level);
        if (height > currentMaxHeights.get(0)) {
            currentMaxHeights.set(1, currentMaxHeights.get(0));
            currentMaxHeights.set(0, height);
        } else if (height > currentMaxHeights.get(1)) {
            currentMaxHeights.set(1, height);
        }

        return height;
    }
}
