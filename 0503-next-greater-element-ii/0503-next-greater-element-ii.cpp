class Solution
{
public:
    vector<int> nextGreaterElements(vector<int> &nums)
    {
        stack<int> st;
        vector<int> res(nums.size(), -1);
        for (size_t i = 0; i < 2 * nums.size(); i++)
        {
            while (!st.empty() && nums[st.top()] < nums[i % nums.size()])
            {
                res[st.top()] = nums[i % nums.size()];
                st.pop();
            }
            st.push(i % nums.size());
        }

        return res;
    }
};