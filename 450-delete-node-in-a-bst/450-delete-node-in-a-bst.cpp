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
        if(root==nullptr)
            return root;
                
        if(root->val < key)
            root->right = deleteNode(root->right , key);
        else if (root->val > key )
            root->left = deleteNode(root->left , key);
        else
        {
            TreeNode* cur = root;
            if(!root->left)
            {               

                root = root->right;
            }
            else if (!root->right)
            {
                root = root->left;
            }
                else
            {
                TreeNode * successor = maxNode (root->left);
                root->val = successor->val;
                root->left = deleteNode(root->left,successor->val);
                cur= nullptr;
            }
            if(cur!=nullptr)
                delete cur;
        }
        
        return root;
    }

    TreeNode *maxNode(TreeNode *root )
    {
        while(root->right!=nullptr)
            root = root->right;
        return root;
    }
        
};