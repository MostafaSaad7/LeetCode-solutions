import java.util.HashMap;
import java.util.Map;

class Solution {

    private final int MOD = 1_000_000_007;
    int rows, cols;
    Map<String, Integer> cache;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        cols = n;
        cache = new HashMap<>();
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int row, int column, int moves) {
        if (moves == -1)
            return 0;
        if (row == -1 || row == rows || column == -1 || column == cols)
            return 1;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(row).append("#").append(column).append("#").append(moves);
        String cacheKey = stringBuilder.toString();

        if (cache.containsKey(cacheKey))
            return cache.get(cacheKey);

        int paths = 0;
        paths = (paths + dfs(row + 1, column, moves - 1)) % MOD;
        paths = (paths + dfs(row - 1, column, moves - 1)) % MOD;
        paths = (paths + dfs(row, column - 1, moves - 1)) % MOD;
        paths = (paths + dfs(row, column + 1, moves - 1)) % MOD;
        
        cache.put(cacheKey, paths);

        return paths;
    }
}
