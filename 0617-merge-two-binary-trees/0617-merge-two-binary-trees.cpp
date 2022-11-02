class Solution
{

public:
    TreeNode *mergeTrees(TreeNode *root1, TreeNode *root2)
    {
        if (!root1 && !root2)
            return nullptr;

        int val = 0, val2 = 0;
        if (root1)
            val = root1->val;
        if (root2)
            val2 = root2->val;
        TreeNode *root = new TreeNode(val + val2);
        if (root1 && root2)
        {
            root->left = mergeTrees(root1->left, root2->left);
            root->right = mergeTrees(root1->right, root2->right);
        }
        else if (root1)
        {
            root->left = mergeTrees(root1->left, nullptr);
            root->right = mergeTrees(root1->right, nullptr);
        }
        else
        {
            root->left = mergeTrees(nullptr, root2->left);
            root->right = mergeTrees(nullptr, root2->right);
        }
        return root;
    }
};