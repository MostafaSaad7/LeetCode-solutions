class Solution {
         public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = Arrays.stream(piles).max().orElseThrow();
        long result = right;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (kokoCanEat(piles, mid, h)) {
                result = Math.min(mid,result);
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }


        return (int)result;
    }

    private boolean kokoCanEat(int[] piles, long k, long h) {
        long totalHours = 0;
        for (Integer bananas : piles) {
            long hours = (int) Math.ceil((double) bananas / k);
            totalHours += hours;

        }

        return totalHours <= h;
    }


}