class Solution
{
public:
    bool isValid(int index, int size)
    {
        if (index < 0 || index >= size)
            return false;
        return true;
    }
    bool canReach(vector<int> &arr, int start)
    {
        if(arr[start]==0)
            return true;
        unordered_set<int> indicesSet;
        queue<int> indicesQ;
        indicesQ.push(start);
        indicesSet.insert(start);
        int sz = arr.size();
        while (!indicesQ.empty())
        {
            int currentIndex = indicesQ.front();
            indicesQ.pop();
            int rightIndex = currentIndex + arr[currentIndex];
            int leftIndex = currentIndex - arr[currentIndex];

            if (isValid(rightIndex, sz) && indicesSet.count(rightIndex) == 0)
            {
                if(arr[rightIndex]==0)
                    return true;
                indicesQ.push(rightIndex);
                indicesSet.insert(rightIndex);
            }

            if (isValid(leftIndex, sz) && indicesSet.count(leftIndex) == 0)
            {
                if(arr[leftIndex]==0)
                    return true;
                indicesQ.push(leftIndex);
                indicesSet.insert(leftIndex);
            }
        }
        return false;
    }
};