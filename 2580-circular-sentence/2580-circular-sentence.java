class Solution {
    public boolean isCircularSentence(String sentence) {


        String[] words = sentence.split(" ");
        final int LEN = words.length;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            String word2 = words[(i + 1) % LEN];
            if (word1.charAt(word1.length()-1) != word2.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}