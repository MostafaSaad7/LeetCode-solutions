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
    bool isValidBST(TreeNode* root) {

        return validation (root , LLONG_MAX  ,LLONG_MIN);

    }
    

    bool validation (TreeNode * root , long max ,long min){
        if(root == nullptr) return true;
        
        if(root->val > min && root->val < max )
            return validation(root->right , max , root->val) && validation(root->left,root->val , min); 
    
        return false ;
            
        
        
        
        
    }
    
    
};