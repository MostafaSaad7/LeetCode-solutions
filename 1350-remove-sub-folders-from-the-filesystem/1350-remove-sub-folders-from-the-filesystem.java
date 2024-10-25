import java.util.*;

class Trie {
    Trie root; // The root of the Trie
    Map<String, Trie> children;
    boolean endOfFolder;

    public Trie() {
        this.children = new HashMap<>();
        this.endOfFolder = false;
        this.root = this; // Initialize the root to point to itself
    }

    // Method to add a path to the Trie
    public void add(String path) {
        Trie cur = root; // Start from the root of the Trie
        String[] folders = path.split("/");

        for (String folder : folders) {
            if (folder.isEmpty()) continue; // Skip empty parts from split
            cur.children.putIfAbsent(folder, new Trie());
            cur = cur.children.get(folder);
        }
        cur.endOfFolder = true;
    }

    // Method to check if the path is a subfolder of any existing folder
    public boolean prefixSearch(String path) {
        Trie cur = root; // Start from the root of the Trie
        String[] folders = path.split("/");

        for (int i = 0; i < folders.length - 1; i++) {
            String folder = folders[i];
            if (folder.isEmpty()) continue; // Skip empty parts from split

            if (!cur.children.containsKey(folder)) {
                return false;
            }
            cur = cur.children.get(folder);
            if (cur.endOfFolder) {
                return true; // A parent folder is found
            }
        }
        return false;
    }
}

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();

        // Add all folders to the Trie
        for (String f : folder) {
            trie.add(f);
        }

        List<String> result = new ArrayList<>();
        // Check if each folder is not a subfolder
        for (String f : folder) {
            if (!trie.prefixSearch(f)) {
                result.add(f);
            }
        }

        return result;
    }
}
