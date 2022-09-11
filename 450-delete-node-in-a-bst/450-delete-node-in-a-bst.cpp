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
TreeNode* parent = root;
				TreeNode* child = root->right;
				while (child->left)
					parent = child, child = child->left;

				root->val = child->val;

				if (parent->right == child) {
					parent->right = child->right;
				}
				else
					parent->left = child->right;
				delete child;
                    cur = nullptr;
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