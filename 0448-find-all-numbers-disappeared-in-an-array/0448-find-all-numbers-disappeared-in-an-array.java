import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            currentNumber = Math.abs(currentNumber);
            if (!(nums[currentNumber - 1] < 0))
                nums[currentNumber - 1] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }
}


// Input: nums = [4,3,2,7,8,2,3,1]

// mark that 4 exist ---> pos 3
// mark that 3 exist ---> pos 2 
// mark that 2 exist ---> pos 1 
// mark that 7 exist ---> pos 6 
// mark that 8 exist ---> pos 7 
// mark that 2 exist ---> pos 1 ----> already exist so 2 at position 5 
// mark that 3 exist ---> pos 2 ----> already exist so 3 at position 6
// mark that 1 exist ---> pos 0  

// i have two missing numbers 
// 4,5 ---->these two position are available 
// Output: [5,6]