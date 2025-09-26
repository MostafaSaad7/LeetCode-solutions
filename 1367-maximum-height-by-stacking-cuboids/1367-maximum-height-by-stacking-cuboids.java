import java.util.*;

class Solution {
    private List<int[]> cuboids;
    private int[][] memory;

    private boolean lessEq(int i, int j) {
        // Only need to compare indices 1 and 2 since cuboid sides are sorted
        return cuboids.get(i)[1] <= cuboids.get(j)[1]
            && cuboids.get(i)[2] <= cuboids.get(j)[2];
    }

    private int LIS(int cur, int prev) {
        if (cur == cuboids.size()) {
            return 0;
        }

        if (memory[cur][prev] != -1) {
            return memory[cur][prev];
        }

        // Choice 1: skip current cuboid
        int choice1 = LIS(cur + 1, prev);

        // Choice 2: take current cuboid if it can be stacked
        int choice2 = 0;
        if (prev == cuboids.size() || lessEq(prev, cur)) {
            choice2 = cuboids.get(cur)[2] + LIS(cur + 1, cur);
        }

        return memory[cur][prev] = Math.max(choice1, choice2);
    }

    public int maxHeight(int[][] cuboidsArr) {
        // Convert to list for easier handling
        cuboids = new ArrayList<>();
        for (int[] c : cuboidsArr) {
            Arrays.sort(c); // sort each cuboid so dimensions are ordered
            cuboids.add(c);
        }

        // Sort cuboids overall
        cuboids.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        int n = cuboids.size();
        memory = new int[n + 1][n + 1]; // extra index for "no previous"
        for (int[] row : memory) {
            Arrays.fill(row, -1);
        }

        // Start with prev = n (meaning no cuboid chosen yet)
        return LIS(0, n);
    }
}
