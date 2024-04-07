class Solution {
    public boolean checkValidString(String s) {
        int openParantMax = 0; // maximum parenthesis that i can have
        int openParantMin = 0; // minimum parenthesis that i can have
        for (char c : s.toCharArray()) {

            if (c == '(') {
                openParantMax++;
                openParantMin++;
            } else if (c == ')') {
                openParantMax--;
                openParantMin--;
            } else {
                openParantMax++; // assume '*' will be open parenthesis 
                openParantMin--; // assume '*' will be close parenthesis 
            }

            if (openParantMax < 0) return false; // eg ))))))(((((****

            openParantMin = Math.max(0, openParantMin);
        }


        return openParantMin == 0; // ()()(*)
    }
}