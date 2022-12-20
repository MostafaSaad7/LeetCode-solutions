class Solution
{
public:
    int getHeight(TreeNode *root)
    {
        if (root == nullptr)
            return 0;
            int left = getHeight(root->left);
    int right = getHeight(root->right);
    if (left == -1 || right == -1 || abs(left - right) > 1)
    {
        return -1;
    }
        return max(left,right) + 1;
    }

    bool isBalanced(TreeNode *root)
    {
        if (root == nullptr)
            return true;
        return getHeight(root)!=-1;
    }
};