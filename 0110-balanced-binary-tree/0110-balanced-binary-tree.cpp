class Solution
{
public:
    pair<bool, int> dfs(TreeNode *root)
    {
        if (root == nullptr)
            return {true, 0};
        auto left = dfs(root->left);
        auto right = dfs(root->right);

        bool balanced = left.first & right.first & (abs(left.second - right.second) <= 1);
        int height = max(left.second, right.second) + 1;
        return {balanced, height};
    }

    bool isBalanced(TreeNode *root)
    {

        return dfs(root).first;
    }
};