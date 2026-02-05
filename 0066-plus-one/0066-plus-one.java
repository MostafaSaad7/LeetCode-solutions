class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;  
        List<Integer> result = new ArrayList<>();
        
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = carry + digits[i];
            result.add(temp % 10);  
            carry = temp / 10;       
        }
        
        if (carry > 0) {
            result.add(carry);
        }
        
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(result.size() - 1 - i);
        }
        
        return answer;
    }
}