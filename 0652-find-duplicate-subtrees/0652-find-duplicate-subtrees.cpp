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
    unordered_map<string, int> mp;
    string
    serializeTree(TreeNode *root, vector<TreeNode *> &nodes)
    {
        string ser = "";
        if (root == nullptr)
            return "#";

         ser += to_string(root->val) + "," + serializeTree(root->left, nodes) + "," + serializeTree(root->right, nodes);
        mp[ser] += 1;
        if (mp[ser] ==2 ) // just push one element
            nodes.push_back(root);

        return ser;
    }

public:
    vector<TreeNode *>
    findDuplicateSubtrees(TreeNode *root)
    {
        vector<TreeNode *> nodes;

        serializeTree(root, nodes);
        return nodes;
    }
};