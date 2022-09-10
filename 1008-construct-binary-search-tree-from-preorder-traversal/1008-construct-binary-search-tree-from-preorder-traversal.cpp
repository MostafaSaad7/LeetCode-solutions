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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return dfs(preorder,0,preorder.size()-1);
    }
    
    TreeNode * dfs(vector<int>& preorder , int left , int right)
    {
        if(left > right )
            return nullptr;
        TreeNode * root = new TreeNode(preorder[left]);
        for(int  i = left+1 ; i<= right ; i++)
        {
            if(preorder[i]> preorder[left])
        
            { 
            root->left = dfs(preorder , left +1, i-1);
            root->right = dfs(preorder , i,right );
                break;
            }
            else if(i == right)
            {
                root->left = dfs(preorder , left +1, right);
                break;

            }
        }
        
        return root ;
    }
        
        
    };