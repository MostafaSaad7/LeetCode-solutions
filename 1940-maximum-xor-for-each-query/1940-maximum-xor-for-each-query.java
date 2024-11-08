class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        /*
        * Explanation of the problem
        *
        * assume all XORs are 100001111101111 and the range that k supports is 2^maximumBit ---> assume that k maximum num is 2^maximumBit -1
        * which covers around 5 bits so our goal is max all 5 bits of result to be 11111
        * so if the bit is 1 then we need to keep as is if it is 0 then we need to flip it
        *
        *
        *
        * XoR result XOR k = 11111
        *
        * so k = 11111 XOR XoR result
        *
        * */


        int [] result = new int[nums.length];
        int mask = (1 << maximumBit) - 1;
        int xOrRes = 0;

        for(int i = 0; i < nums.length; i++){
            xOrRes = xOrRes ^ nums[i];
        }

        for(int i = 0; i < nums.length; i++){
            result[i] = xOrRes ^ mask;
            xOrRes = xOrRes ^ nums[nums.length - i - 1]; // to remove the last element 
        }
        return result;   // result represents the k values to make xor result maximum for each number

    }
}