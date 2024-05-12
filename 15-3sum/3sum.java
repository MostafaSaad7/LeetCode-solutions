import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) { // outer loop for the first number

            if (i > 0 && nums[i] == nums[i - 1])
                continue; // remove duplicates, since the first number if repeated then we will get the same result


            // now it's two sume problem and will be solved using two pointers
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum < 0)
                    left++;
                else if (sum > 0)
                    right--;
                else {

                    result.add(List.of(nums[left], nums[right], nums[i]));
                    // remove duplicates now from the left and the right
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;


                }


            }

        }

        return result;
    }
}

/*

*
Input: nums = [-1,0,1,2,-1,-4]

        [-4,-1,-1,0,1,2]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.*
*
*
*
*
* */