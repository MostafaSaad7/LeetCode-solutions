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
    bool isSymmetric(TreeNode* root) {
        
        return symmetricSubtree(root->left,root->right);
        
    }
    
    bool symmetricSubtree(TreeNode* left , TreeNode* right){
        if(left && right && left->val == right->val)
            return (symmetricSubtree(left->left ,right->right) && symmetricSubtree(left->right ,right->left));
        
        else if(left == nullptr && right == nullptr)
            return true;
        else
        return false;
    }
};