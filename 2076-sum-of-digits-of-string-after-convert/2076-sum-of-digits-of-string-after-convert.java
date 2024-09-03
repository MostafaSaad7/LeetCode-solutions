class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            int value = c - 'a' + 1; 
            sb.append(value);
        }
        
        String numStr = sb.toString();
        int result = 0;
        while (k-- > 0) {
            result = 0;
            for (char c : numStr.toCharArray()) {
                result += c - '0'; // Convert char to int and sum up
            }
            numStr = String.valueOf(result);
        }
        
        return result;
    }
}
