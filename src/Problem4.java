import java.io.PrintStream;
import java.util.Arrays;

public class Problem4 {
    public String solve() {
        return Double.toString(findMedianSortedArrays(new int[]{2}, new int[]{1, 3, 4}));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // Flag for keeping track of smaller list
        boolean flag = m <= n;
        // Run function now knowing sizes and smaller
        if (flag) {
            return medianSorted(nums1, nums2, m, n);
        }
        else {
            return medianSorted(nums2, nums1, n, m);
        }
    }
    private double medianSorted(int[] nums1, int[] nums2, int m, int n) {
        int size = (m + n) / 2;
        int pointer1 = (m - 1) / 2;
        int pointer2 = size - pointer1 - 2;
        while (getValue(nums1, m, pointer1) > getValue(nums2, n, pointer2 + 1) ||
        getValue(nums2, n, pointer2) > getValue(nums1, m, pointer1 + 1)) {
            if (getValue(nums1, m, pointer1) > getValue(nums2, n, pointer2 + 1)) {
                pointer1 -= 1;
                pointer2 += 1;
            }
            else {
                pointer1 += 1;
                pointer2 -= 1;
            }
        }
        // Same size arrays
        if (m == n) {
            if (pointer1 < 0) {
                return (getValue(nums1, m, 0) + getValue(nums2, n, n-1)) / 2.0;
            }
            else if (pointer2 < 0) {
                return (getValue(nums1, m, m-1) + getValue(nums2, n, 0)) / 2.0;
            }
            else {
                return (Math.max(getValue(nums1, m, pointer1),
                        getValue(nums2, n, pointer2)) +
                        Math.min(getValue(nums1, m, pointer1 + 1),
                                getValue(nums2, n, pointer2 + 1))) / 2.0;
            }
        }
        // Odd
        if ((m + n) % 2 != 0) {
            if (pointer1 < 0) {
                return Math.min(getValue(nums1, m, 0),
                        getValue(nums2, n, pointer2 + 1));
            }
            else if (pointer1 >= m - 1) {
                return getValue(nums2, n, size - m);
            }
            else {
                return Math.min(getValue(nums1, m, pointer1 + 1),
                        getValue(nums2, n, pointer2 + 1));
            }
        }
        // Even
        else {
            if (pointer1 < 0) {
                return (getValue(nums2, n, pointer2) +
                        Math.min(getValue(nums1, m, 0),
                        getValue(nums2, n, pointer2 + 1))) / 2.0;
            }
            else if (pointer1 >= m - 1) {
                return (Math.max(getValue(nums1, m, m-1), getValue(nums2, n, pointer2)) +
                        getValue(nums2, n, pointer2 + 1)) / 2.0;
            }
            else {
                return (Math.max(getValue(nums1, m, pointer1),
                        getValue(nums2, n, pointer2)) +
                        Math.min(getValue(nums1, m, pointer1 + 1),
                                getValue(nums2, n, pointer2 + 1))) / 2.0;
            }
        }
    }
    private int getValue(int[] nums, int n, int index) {
        if (index < 0) {
            return -Integer.MAX_VALUE;
        }
        else if (index >= n) {
            return Integer.MAX_VALUE;
        }
        else {
            return nums[index];
        }
    }
}
