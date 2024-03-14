import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

class Solution {
    public int missingNumber(int[] nums) {

        HashSet<Integer> numSet = (HashSet<Integer>) Arrays.stream(nums)
                .boxed()  // Convert int to Integer to use Collectors.toSet()
                .collect(Collectors.toSet());

        for (int i = 0 ; i<=nums.length;i++)
        {
            if (!numSet.contains(i))
                return i;
        }
        
        
        return 0;

    }
}