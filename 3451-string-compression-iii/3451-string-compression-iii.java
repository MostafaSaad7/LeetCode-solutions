class Solution {
    public String compressedString(String word) {
        if (word == null || word.length() == 0) return "";

        char currentChar = word.charAt(0);
        int counter = 1;
        StringBuilder res = new StringBuilder();

        for (int index = 1; index < word.length(); index++) {
            if (word.charAt(index) == currentChar) {
                counter++;
                if (counter == 10) {  // Append groups of 9
                    res.append(9).append(currentChar);
                    counter = 1;  // Start counting new batch
                }
            } else {
                res.append(counter).append(currentChar);
                currentChar = word.charAt(index);
                counter = 1;
            }
        }

        // Append remaining character count
        res.append(counter).append(currentChar);

        return res.toString();
    }
}
