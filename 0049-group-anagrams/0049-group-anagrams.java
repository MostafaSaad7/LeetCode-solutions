class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          if (strs.length <= 1) {
            // If there's only one or zero strings, return a single-element list containing the input array.
            List<List<String>> result = new ArrayList<>();
            result.add(Arrays.asList(strs));
            return result;
        }

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




