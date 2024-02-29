class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftPointer = 0;
        int rightPointer = numbers.length - 1;
        int[] idices = new int[2];

        while (leftPointer < rightPointer) {
            if (numbers[leftPointer] + numbers[rightPointer] == target) {
                idices[0] = leftPointer + 1;
                idices[1] = rightPointer + 1;
                break;
            } else if (numbers[leftPointer] + numbers[rightPointer] > target) {
                rightPointer--;
            } else if (numbers[leftPointer] + numbers[rightPointer] < target) {
                leftPointer++;
            }


        }


        return idices;
    }
}