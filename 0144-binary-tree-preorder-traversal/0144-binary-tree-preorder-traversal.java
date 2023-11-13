/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public void preOrderTrav(TreeNode treeNode, List<Integer> treeNodeList) {
        if (treeNode==null)
            return;

        treeNodeList.add(treeNode.val);
        preOrderTrav(treeNode.left,treeNodeList);
        preOrderTrav(treeNode.right,treeNodeList);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        preOrderTrav(root,list);
        return list;
    }

}
