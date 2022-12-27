/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution
{
public:
    vector<vector<int>> levelOrder(Node *root)
    {
        vector<vector<int>> ans;
        if (root == nullptr)
            return ans;

        queue<Node *> q;
        q.push(root);

        for (int level = 0, sz = q.size(); sz != 0; level++, sz = q.size())
        {
            vector<int> v{};
            while (sz--)
            {
                Node *temp = q.front();
                q.pop();
                v.push_back(temp->val);

                for (Node *i : temp->children)
                {
                    if (i == nullptr)
                        continue;
                    q.push(i);
                }
            }

            ans.push_back(v);
        }
        return ans;
    }
};