import java.util.*;




class Solution {
    Map<Integer, Employee> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        for (var emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(id);
    }

    int dfs(int id) {
        visited.add(id);
        result += map.get(id).importance;
        for (int subC : map.get(id).subordinates) {
            if (visited.contains(subC)) continue;
            dfs(subC);
        }
        return result;
    }
}