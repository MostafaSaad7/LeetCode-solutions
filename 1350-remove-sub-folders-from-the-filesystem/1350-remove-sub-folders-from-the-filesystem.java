
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (String f : folder) {
            trie.add(f);
        }
        List<String> result = new ArrayList<>();
        for (String f : folder) {
            if (!trie.prefixSearch(f)) {
                result.add(f);
            }
        }
        return result;
    }


    class Trie {
        Map<String, Trie> children;
        boolean isEndOfFolder;
        public Trie() {
      
            this.children = new HashMap<>();
            this.isEndOfFolder = false;
        }
        public void add(String path) {
            Trie currentNode = this;
            String[] folders = path.split("/");
            for (int i = 0; i < folders.length; i++) {
                if (folders[i].isEmpty()) continue;
                currentNode.children.putIfAbsent(folders[i], new Trie());
                currentNode = currentNode.children.get(folders[i]);
            }
            currentNode.isEndOfFolder = true;
        }
        
        public boolean prefixSearch(String path) {
            Trie currentNode = this;
            String[] folders = path.split("/");
            for (int i = 0; i < folders.length - 1; i++) {
                String folder = folders[i];
                if (folder.isEmpty()) continue;
                if (!currentNode.children.containsKey(folder)) {
                    return false;
                }
                currentNode = currentNode.children.get(folder);
                if (currentNode.isEndOfFolder) {
                    return true;
                }
            }
            return false;
        }
    }
}