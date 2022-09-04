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
    bool isCompleteTree(TreeNode* root) {

        queue<TreeNode *> q;
        q.push(root);
        bool allow = true;
        while (!q.empty())
        {
            int sz = q.size();
            while (sz)
            {
                TreeNode *current = q.front();
                q.pop();
                if (current->left)
                {
                    if(!allow)
                        return false;
                    q.push(current->left);
                }
                else 
                    allow = false;
                if(current->right)
                {
                    if(!allow)
                        return false;
                    q.push(current->right);

                }
                else
                    allow = false;
                
                sz--;
            }
        }
        return true;
            
    }
};