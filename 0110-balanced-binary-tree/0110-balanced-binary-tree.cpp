class Solution
{
public:
    int getHeight(TreeNode *root)
    {
        if (root == nullptr)
            return -1;
        return max(getHeight(root->left), getHeight(root->right)) + 1;
    }

    bool isBalanced(TreeNode *root)
    {
        if (root == nullptr)
            return true;

        int leftH = getHeight(root->left) + 1;
        int rightH = getHeight(root->right) + 1;
        bool leftRes = true;
        bool rightRes = true;
        if (abs(leftH - rightH) <= 1 && abs(leftH - rightH) >= 0)
        {
            leftRes = isBalanced(root->left);
            rightRes = isBalanced(root->right);
        }
        else
            return false;
        return leftRes && rightRes;
    }
};