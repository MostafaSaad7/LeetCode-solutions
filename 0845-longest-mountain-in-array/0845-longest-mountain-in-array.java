class Solution {
    public int longestMountain(int[] arr) {

        int maximumMountainHeight = 0;
        int mountainPointerEnd = 0;
        int mountainPointerStart = 0;
        while (mountainPointerEnd < arr.length) {
            mountainPointerStart = mountainPointerEnd;

            // going up
            while (mountainPointerEnd + 1 < arr.length && arr[mountainPointerEnd + 1] > arr[mountainPointerEnd])
                mountainPointerEnd++;

            // if we didn't move
            if (mountainPointerEnd == mountainPointerStart) {
                mountainPointerEnd++;
                continue;
            }
            int peakPosition = mountainPointerEnd;
            while (mountainPointerEnd + 1 < arr.length && arr[mountainPointerEnd + 1] < arr[mountainPointerEnd])
                mountainPointerEnd++;

            if (mountainPointerEnd == peakPosition) {
                mountainPointerEnd++;
                continue;
            }
            maximumMountainHeight = Math.max(maximumMountainHeight, mountainPointerEnd - mountainPointerStart + 1);

        }

        return maximumMountainHeight;
    }
}