class Solution {     
    public boolean isHappy(int n) {         
        HashSet<Integer> hashSet = new HashSet<>();         
        while (n != 1) {             
            n = getNextNum(n);             
            if (hashSet.contains(n)) return false;             
            hashSet.add(n);         
        }          
        return true;  // Reached 1 = happy number
    }      

    int getNextNum(int n) {         
        int nextNum = 0;         
        while (n > 0) {             
            int num = n % 10;      // Get last digit
            n /= 10;               // Remove last digit
            nextNum += num * num;  // Add square
        }         
        return nextNum;     
    } 
}