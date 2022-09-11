// #include <iostream>
// #include <cassert>
// #include <vector>
// #include <queue>
// #include <stack>
// #include <algorithm>
// using namespace std;

// struct TreeNode
// {
//     int val;
//     TreeNode *left;
//     TreeNode *right;
//     TreeNode() : val(0), left(nullptr), right(nullptr) {}
//     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
//     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
// };

class Solution
{
public:
    TreeNode *bstFromPreorder(vector<int> &preorder)
    {
        vector<int> nextGreaterIndx = next_greater_idx(preorder);
        return dfs(preorder, 0, preorder.size() - 1, nextGreaterIndx);
    }

    TreeNode *dfs(vector<int> &preorder, int left, int right, vector<int> &nextGreaterIndx)
    {
        if (left > right)
            return nullptr;
        TreeNode *root = new TreeNode(preorder[left]);
        root->left = dfs(preorder, left + 1, nextGreaterIndx[left] - 1, nextGreaterIndx);
        root->right = dfs(preorder, nextGreaterIndx[left], right, nextGreaterIndx);

        return root;
    }

    vector<int> next_greater_idx(vector<int> &preorder)
    {
        if (preorder.size() == 0)
            return {};
        vector<int> nextGreaterIndx(preorder.size());
        stack<int> smallIndices;
        smallIndices.push(0);
        for (int i = 1; i < preorder.size(); i++)
        {

            while (!smallIndices.empty() && preorder[i] > preorder[smallIndices.top()])
            {
                nextGreaterIndx[smallIndices.top()] = i;
                smallIndices.pop();
            }
            smallIndices.push(i);
        }

        while (!smallIndices.empty())
        {
            nextGreaterIndx[smallIndices.top()] = preorder.size();
            smallIndices.pop();
        }
        return nextGreaterIndx;
    }
};