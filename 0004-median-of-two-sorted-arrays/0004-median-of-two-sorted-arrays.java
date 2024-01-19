class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int pt1 = 0, pt2 = 0,resPtr=0;
        int[] res = new int[nums2.length+nums1.length];
        while (pt1 < nums1.length && pt2 < nums2.length) {
            if (nums1[pt1]<=nums2[pt2])
            {
                res[resPtr++]=nums1[pt1];
                pt1++;
            }
            else {
                res[resPtr++]=nums2[pt2];
                pt2++;
            }

        }
        while (pt1 < nums1.length)
        {                res[resPtr++]=nums1[pt1];
            pt1++;

        }        while (pt2 < nums2.length)
        {                res[resPtr++]=nums2[pt2];
            pt2++;

        }
        if (res.length%2!=0)
        {
            return (double) res[res.length/2];
        }
        else
        {
            return (double) (res[res.length / 2] + res[(res.length / 2) - 1]) /2;
        }

    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,3},new int[]{2});
    }
}