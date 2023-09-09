class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Convert the string to a character array, sort it, and convert it back to a string.
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // Check if the sorted string is already in the map, if not, create a new list for it.
            if (!anagramGroups.containsKey(sortedStr)) {
                anagramGroups.put(sortedStr, new ArrayList<>());
            }
            
            // Add the original string to the corresponding group.
            anagramGroups.get(sortedStr).add(str);
        }
        
        return new ArrayList<>(anagramGroups.values());
    }
}




