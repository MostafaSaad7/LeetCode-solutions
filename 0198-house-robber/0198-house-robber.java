import java.util.Arrays;

class Solution {

    int memory[][] = new int[101][101];
    private int currentHouse;
    private int prevHouse;

    public int rob(int[] nums) {


        for (int[] arr : memory) {
            Arrays.fill(arr, -1);
        }

        return robTheHouses(0, 0, nums);


    }


    int robTheHouses(int currentHouse, int prevHouse, int[] nums) {

        if (currentHouse >= nums.length)
            return 0;
        if (memory[currentHouse][prevHouse] != -1)
            return memory[currentHouse][prevHouse];
        int leaveThisHouseChoice = robTheHouses(currentHouse + 1, currentHouse, nums);
        int robThisHouseChoice = nums[currentHouse] + robTheHouses(currentHouse + 2, currentHouse, nums);
        memory[currentHouse][prevHouse] = Math.max(leaveThisHouseChoice, robThisHouseChoice);
        return memory[currentHouse][prevHouse];
    }
}