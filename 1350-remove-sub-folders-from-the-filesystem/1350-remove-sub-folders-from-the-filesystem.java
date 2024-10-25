import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folders lexicographically
        Arrays.sort(folder);
        List<String> result = new LinkedList<>();

        // Add the first folder to the result as the base case
        result.add(folder[0]);

        // Iterate over the sorted folders starting from the second one
        for (int i = 1; i < folder.length; i++) {
            // Get the last folder added to the result
            String lastAdded = result.get(result.size() - 1);

            // Check if the current folder is a subfolder of the last added folder
            // A folder is considered a subfolder if it starts with the last added folder plus a '/'
            if (!(folder[i].startsWith(lastAdded) && folder[i].charAt(lastAdded.length()) == '/')) {
                // If it's not a subfolder, add it to the result
                result.add(folder[i]);
            }
        }

        return result;
    }
}
