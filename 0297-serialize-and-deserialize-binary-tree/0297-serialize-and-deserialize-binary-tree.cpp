class Codec
{
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode *root)
    {
        if (root == nullptr)
            return "# ";
        string res = to_string(root->val) + " " + serialize(root->left) + " " + serialize(root->right);

        return res;
    }

    TreeNode *deserialize(string data)
    {
        istringstream in(data);
        return dfs(in);
    }

    TreeNode *dfs(istringstream &in)
    {
        string s;
        in >> s;
        if (s == "#")
            return nullptr;
        TreeNode *root = new TreeNode(stoi(s));
        root->left = dfs(in);
        root->right = dfs(in);
        return root;
    }
};