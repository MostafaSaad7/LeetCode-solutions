/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution
{
private:
    unordered_map<int, Employee *> mp; // id >> emp ----> to reduce search time in //emp  vector

public:
    int getImportance(vector<Employee *> & employees, int id)
    {
        mapVec(employees);
        Employee *emp = mp[id];

        int sum = emp->importance;
        for (auto &subordinate : emp->subordinates)
        {
            sum += getImportance(employees, subordinate);
        }
        return sum;
    }

    void mapVec(vector<Employee *> &employees)
    {
        for (auto &i : employees)
        {
            mp[i->id] = i;
        }
    }
};