import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    List<List<Integer>> graph;

    public void addUndirectedEdge(int from, int to) {
        if (graph.get(from) == null) {
            graph.set(from, new ArrayList<>());
        }
        if (graph.get(to) == null) {
            graph.set(to, new ArrayList<>());
        }
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    public void dfs(int node, HashSet<Integer> visited, List<Integer> ccNodes) {
        visited.add(node);
        ccNodes.add(node);

        for (int neighbour : graph.get(node)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited, ccNodes);
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int nodes = s.length();
        graph = new ArrayList<>(nodes);
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < nodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> pair : pairs) {
            addUndirectedEdge(pair.get(0), pair.get(1));
        }

        char[] str = s.toCharArray(); // Convert string to char array for manipulation

        for (int i = 0; i < nodes; i++) {
            if (!visited.contains(i)) {
                List<Integer> cc_nodes = new ArrayList<>();
                dfs(i, visited, cc_nodes);
                List<Character> cc_letters = new ArrayList<>();
                for (int node : cc_nodes) {
                    cc_letters.add(s.charAt(node));
                }
                cc_nodes.sort(null); // Sort the indices
                cc_letters.sort(null); // Sort the characters

                // Assign sorted characters to their correct positions in the char array
                for (int j = 0; j < cc_nodes.size(); j++) {
                    str[cc_nodes.get(j)] = cc_letters.get(j);
                }
            }
        }
        return new String(str); // Convert char array back to string
    }
}
