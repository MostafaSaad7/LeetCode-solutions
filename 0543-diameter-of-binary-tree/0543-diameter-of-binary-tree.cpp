class Solution
{
    int maxD = 0;

public:
    int DFS(TreeNode *root)
    {
        if (root == nullptr)
            return 0;

        int leftH = DFS(root->left);
        int rightH = DFS(root->right);
        maxD = max(maxD,leftH + rightH);
        return 1 + max(leftH, rightH);
    }
    int diameterOfBinaryTree(TreeNode *root)
    {
        DFS(root);
        return maxD;
    }
};