import java.util.Arrays;

class Solution {

    int memory[] = new int[101];
    public int rob(int[] nums) {
        Arrays.fill(memory, -1);
        return robTheHouses(0, nums);
    }


    int robTheHouses(int currentHouse, int[] nums) {

        if (currentHouse >= nums.length)
            return 0;
        if (memory[currentHouse] != -1)
            return memory[currentHouse];
        int leaveThisHouseChoice = robTheHouses(currentHouse + 1, nums);
        int robThisHouseChoice = nums[currentHouse] + robTheHouses(currentHouse + 2, nums);
        memory[currentHouse] = Math.max(leaveThisHouseChoice, robThisHouseChoice);
        return memory[currentHouse];
    }
}