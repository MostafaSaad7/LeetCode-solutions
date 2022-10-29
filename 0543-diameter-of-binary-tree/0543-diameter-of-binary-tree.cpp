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
    int diameterOfBinaryTree(TreeNode* root){
        return diameterOfBinaryTree2(root).first;
    }
    pair<int,int> diameterOfBinaryTree2(TreeNode* root) {
        pair <int ,int>res= make_pair(0,0);
        
        if(!root->left && !root->right)
                return res;
        pair <int ,int>leftD= make_pair(0,0);
        pair <int ,int>rightD= make_pair(0,0);
        
        if(root->left)
            leftD=diameterOfBinaryTree2(root->left),res.first+= 1+leftD.second;
        if(root->right)
            rightD=diameterOfBinaryTree2(root->right),res.first+= 1+rightD.second;
        
        res.second = 1+max(leftD.second,rightD.second);
        res.first = max(res.first,max(leftD.first,rightD.first));
        
        return res;
        

    }
};