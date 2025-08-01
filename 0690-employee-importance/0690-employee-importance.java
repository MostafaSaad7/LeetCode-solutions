class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        return dfs(map, id);
    }
    
    private int dfs(Map<Integer, Employee> map, int id) {
        Employee emp = map.get(id);
        int total = emp.importance;
        
        for (int subId : emp.subordinates) {
            total += dfs(map, subId);
        }
        return total;
    }
}