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
class Solution
{
public:
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        return treeBuilder(preorder, inorder, 0, (int)inorder.size() - 1, 0);
    }

    TreeNode *treeBuilder(vector<int> &preorder, vector<int> &inorder, int inStart = 0, int inEnd = -1, int preIt = 0)
    {
        if (preIt > preorder.size() - 1 || inStart > inEnd)
            return nullptr;

        TreeNode *root = new TreeNode(preorder[preIt]);
        int idx=0;
        for (int i = inStart; i <= inEnd; i++)
        {
            if (inorder[i] == root->val)
            {
            idx=i;
            }

        }
        
root->left = treeBuilder(preorder, inorder, inStart, idx - 1, preIt + 1);
root->right = treeBuilder(preorder, inorder, idx + 1, inEnd, preIt + (idx - inStart + 1));

        return root;
    }
};