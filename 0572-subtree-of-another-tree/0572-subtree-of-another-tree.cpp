class Solution
{
public:
    bool isSubtree(TreeNode *root, TreeNode *subRoot)
    {
        if (!root)
            return false;

        bool res = isSameTree(root, subRoot);

        return res || isSubtree(root->left, subRoot) || isSubtree(root->right, subRoot);
    }
    bool isSameTree(TreeNode *root, TreeNode *subRoot)
    {
        if (!subRoot || !root)
            return !subRoot && !root;
        if (subRoot->val == root->val)
        {
            return isSameTree(root->left, subRoot->left) && isSameTree(root->right, subRoot->right);
        }
        return false;
    }
};