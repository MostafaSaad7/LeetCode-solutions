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
public:
    int sum = 0;
    int getImportance(vector<Employee *> employees, int id)
    {
        for (int i = 0; i < employees.size(); i++)
        {
            if (employees[i]->id == id)
            {
                sum += employees[i]->importance;
                for (int x : employees[i]->subordinates)
                {
                    getImportance(employees, x);
                }
            }
        }

        return sum;
    }
};