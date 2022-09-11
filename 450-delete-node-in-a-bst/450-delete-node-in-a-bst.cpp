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
    TreeNode* deleteNode(TreeNode* root, int key) 
    {
        if(root != nullptr)
        {       
        if(root->val < key)
            root->right = deleteNode(root->right , key);
        else if (root->val > key )
            root->left = deleteNode(root->left , key);
        else
        {
            TreeNode* cur = root;
            if(!root->left)
                return root->right;
            else if (!root->right)
                return root->left;
            else
            {
                TreeNode * successor = minNode (root->right);
                root->val = successor->val;
                root->right = deleteNode(root->right,successor->val);
                cur= nullptr;
            }
            if(cur!=nullptr)
                delete cur;
        }
        }
        return root;
    }

    TreeNode *minNode(TreeNode *root )
    {
        while(root->left!=nullptr)
            root = root->left;
        return root;
    }
        
        
};