class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; ++i)
            // correct position for i is i or i-1 or i+1 so that the local = global otherwise the global > local
            if (Math.abs(A[i] - i) > 1) return false;
        return true;
    }
}