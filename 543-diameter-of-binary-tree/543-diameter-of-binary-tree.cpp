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
    
    int diameterOfBinaryTree(TreeNode* root) {
        int l =0; 
        int r = 0; 
        if(root==nullptr)
            return 0;
        if(root->left)
            l=height(root->left)+1;
          if(root->right)
            r=height(root->right)+1;
    return max(l+r,max(diameterOfBinaryTree(root->left),diameterOfBinaryTree(root->right)));

        
    }
    	  int height(TreeNode* root) {
        
          if(root == nullptr) 
            return -1;
        
         return 1 + max(height(root->left), height(root->right));
         
    }
};