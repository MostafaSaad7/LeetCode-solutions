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
    int kthSmallest(TreeNode* root, int &k) {
        if(k==0)
            return INT_MIN;
        if(root->left )
        {
            int ss=  kthSmallest(root->left,k);
            if(k==0)
                return ss;
        }
        
        --k;
        if(k==0)
            return root->val ;
    
        if(root->right )
            return kthSmallest(root->right,k);
  
        return INT_MIN;
        
    }
    
    
    
};