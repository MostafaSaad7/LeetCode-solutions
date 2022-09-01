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
    vector<vector<int>> levelOrder(TreeNode* root) {
        int sz=0;
        queue<TreeNode *> q;
        if(root!=nullptr)
            q.push(root);
        vector<vector<int>> res;
        while (!q.empty())
        {   vector<int> v;
            sz=q.size();
            while(sz--){
            TreeNode *current = q.front();
            q.pop();
            v.push_back(current->val);
            if (current->left != nullptr)
            {
                q.push(current->left);
            }

            if (current->right != nullptr)
            {
                q.push(current->right);
            }
            }
            
            res.push_back(v);
        }
        
        return res;
        
    }
};