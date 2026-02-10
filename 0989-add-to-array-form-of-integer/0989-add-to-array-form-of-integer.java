class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int i = num.length - 1;
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        while (carry != 0 || i > -1 || k != 0) {
            if (i > -1) carry += num[i--];     
            carry += k % 10;
            k /= 10;
            result.add(carry % 10);
            carry /= 10;                        
        }
        Collections.reverse(result);            
        return result;
    }
}