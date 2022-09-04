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
class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        if(root==nullptr)
            return res;
         deque<TreeNode *> dq;
        dq.push_back(root);
        bool isForward = true;
        int level = 0;
        while (!dq.empty())
        {
            int sz = dq.size();
            vector <int>v;
            while (sz--)
            {
                if (isForward)
                {

                    TreeNode *current = dq.front();
                    dq.pop_front();
                    v.push_back(current->val);
                    if (current->left)
                    {
                        dq.push_back(current->left);
                    }
                    if (current->right)
                    {
                        dq.push_back(current->right);
                    }
                }
                else
                {
                    TreeNode *current = dq.back();
                    dq.pop_back();
                    v.push_back(current->val);
                    if (current->right)
                    {
                        dq.push_front(current->right);
                    }
                    if (current->left)
                    {
                        dq.push_front(current->left);
                    }
                }
            }
            isForward = !isForward;
            res.push_back(v);
        }
        
        
        return res;
        
    }
};