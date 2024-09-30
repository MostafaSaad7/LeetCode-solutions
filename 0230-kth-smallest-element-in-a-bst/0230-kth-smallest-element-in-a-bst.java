import java.util.PriorityQueue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public int kthSmallest(TreeNode root, int k) {


        dfs(root);
        
        int res =-1;
        while (k--!=0)
        {
            res=priorityQueue.poll();
        }
        
        return res;
    }

    private void dfs(TreeNode root) {
        
        if (root==null)
            return;
        priorityQueue.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}