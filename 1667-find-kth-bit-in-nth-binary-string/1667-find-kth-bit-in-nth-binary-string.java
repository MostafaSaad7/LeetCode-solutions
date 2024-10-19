class Solution {
    public char findKthBit(int n, int k) {
        int inversionCount = 0;
        int len = (1 << n) - 1;

        while (k > 1) {
            if (k == (len / 2) + 1) 
                return (inversionCount & 1) == 1 ? '0' : '1';

            if (k > len / 2) {
                k = len - k + 1;
                inversionCount++;

            }
            len = len / 2;
        }

        return (inversionCount & 1) == 1 ? '1' : '0';
    }
}