/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution
{
public:
    // for each level you get one node
    vector<int> rightSideView(TreeNode *root)
    {
        if (!root)
            return {};
        vector<int> res;
        queue<TreeNode *> q;
        q.push(root);
        for (int level = 0, sz = q.size(); !q.empty(); level++, sz = q.size())
        {
            while (sz--)
            {
                TreeNode *curr = q.front();
                q.pop();
                if (curr->left)
                    q.push(curr->left);
                if (curr->right)
                    q.push(curr->right);
                if (!sz)
                    res.push_back(curr->val);
            }
        }
        return res;
    }
};