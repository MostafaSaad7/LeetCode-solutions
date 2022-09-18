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
class Solution {
public:
       bool findTarget(TreeNode* root, int k) {
        unordered_set<int> set;
        return helper(root, set, k);
    }
    
    bool helper(TreeNode* root, unordered_set<int>& set, int k){
        if(!root)
            return false;
        if(set.count(k - root->val)!=0)
            return true;
        set.insert(root->val);
        return helper(root->left, set, k) || helper(root->right, set, k);
    }
};