import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> currentElements = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
            dfs(0);
 
        return result;
    }

    private boolean dfs(Integer node) {

        currentElements.add(node);

        if (node==graph.length-1)
            result.add(new ArrayList<>(currentElements));
        for (var neighbours : graph[node]) {
            dfs(neighbours);
        }

        currentElements.remove(node);


//        for (var neighbours : graph[node]) {
//            if (dfs(neighbours) && !visited.contains(neighbours)) {
//                visited.add(neighbours);
//                currentElements.add(node);
//                result.add(currentElements);
//                currentElements.remove(node);
//                visited.remove(neighbours);
//
//            }
//        }
        return false;
    }
}