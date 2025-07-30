class Solution {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26]; // for lowercase letters a-z
            isEnd = false;
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Build trie with first string
        TrieNode root = new TrieNode();
        insertWord(root, strs[0]);
        
        // For each subsequent string, keep only common prefixes
        for (int i = 1; i < strs.length; i++) {
            root = getCommonPrefix(root, strs[i]);
        }
        
        // Extract the longest common prefix from trie
        return buildPrefix(root);
    }
    
    private void insertWord(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    private TrieNode getCommonPrefix(TrieNode root, String word) {
        TrieNode newRoot = new TrieNode();
        TrieNode curr = root;
        TrieNode newCurr = newRoot;
        
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                break; // No common prefix beyond this point
            }
            newCurr.children[index] = new TrieNode();
            curr = curr.children[index];
            newCurr = newCurr.children[index];
        }
        
        return newRoot;
    }
    
    private String buildPrefix(TrieNode root) {
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = root;
        
        while (curr != null) {
            int childCount = 0;
            int childIndex = -1;
            
            // Count children and find the single child if exists
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null) {
                    childCount++;
                    childIndex = i;
                }
            }
            
            // If there's exactly one child, continue building prefix
            if (childCount == 1) {
                prefix.append((char)('a' + childIndex));
                curr = curr.children[childIndex];
            } else {
                break; // Multiple children or no children
            }
        }
        
        return prefix.toString();
    }
}