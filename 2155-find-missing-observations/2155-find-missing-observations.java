class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total_sum = mean * (m + n);
        int sum_of_rolls = 0;
        
  
        for (int roll : rolls) {
            sum_of_rolls += roll;
        }
        
        int sum_of_missing_rolls = total_sum - sum_of_rolls;
        
        if (sum_of_missing_rolls < n || sum_of_missing_rolls > n * 6) {
            return new int[0];
        }
        
        int[] result = new int[n];
        int average = sum_of_missing_rolls / n;
        int remainder = sum_of_missing_rolls % n;
        
       
        for (int i = 0; i < n; i++) {
            result[i] = average + (i < remainder ? 1 : 0);
        }
        
        return result;
    }
}
