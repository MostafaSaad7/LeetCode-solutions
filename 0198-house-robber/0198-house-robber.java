import java.util.Arrays;

class Solution {

    public int rob(int[] nums) {

        int memory[] = new int[nums.length];
        Arrays.fill(memory, -1);

        for (int i = 0; i < nums.length; i++) {
            int robThisHouseChoice = nums[i];
            if (i - 2 >= 0 && memory[i - 2] != -1)
                robThisHouseChoice += memory[i - 2];

            int donRob = 0;
            if (i - 1 >= 0 && memory[i - 1] != -1)
                donRob = memory[i - 1];
            memory[i] = Math.max(robThisHouseChoice, donRob);
        }


        return memory[nums.length - 1];
    }
}