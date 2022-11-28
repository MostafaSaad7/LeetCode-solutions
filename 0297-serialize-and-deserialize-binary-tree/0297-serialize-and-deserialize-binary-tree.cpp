class Codec
{
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode *root)
    {
        ostringstream s;
        ser(root, s);
        return s.str();
    }

    TreeNode *deserialize(string data)
    {
        istringstream in(data);
        return dfs(in);
    }

    void ser(TreeNode *root, ostringstream &s)
    {
        if (!root)
            s << "#"
              << " ";
        else
        {
            s << root->val << " ";
            ser(root->left, s);
            ser(root->right, s);
        }
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
