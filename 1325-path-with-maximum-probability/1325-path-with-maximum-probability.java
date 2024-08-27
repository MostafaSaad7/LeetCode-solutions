import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // Graph represented as an adjacency list
        List<Map<Integer, Double>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        
        // Build the graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).put(v, prob);
            graph.get(v).put(u, prob);
        }
        
        // Priority Queue to hold the max probability paths
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.add(new double[]{start_node, 1.0});
        
        // Array to store the max probability to reach each node
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        // Dijkstra-like approach
        while (!pq.isEmpty()) {
            double[] curr = pq.poll();
            int node = (int) curr[0];
            double prob = curr[1];
            
            if (node == end_node) {
                return prob;
            }
            
            // Explore neighbors
            for (int neighbor : graph.get(node).keySet()) {
                double newProb = prob * graph.get(node).get(neighbor);
                if (newProb > maxProb[neighbor]) {
                    maxProb[neighbor] = newProb;
                    pq.add(new double[]{neighbor, newProb});
                }
            }
        }
        
        return 0.0;
    }
}
