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
          
                TreeNode *current = q.front();
                q.pop();
                if(current==nullptr)
                    allow=false;
                else
                {
                if(!allow)
                        return false;
                q.push(current->left);
                q.push(current->right);
                }
                
        
        }
        return true;
            
    }
};