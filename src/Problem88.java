import java.util.Arrays;

public class Problem88 implements Problem {
    @Override
    public String solve() {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        return Arrays.toString(nums1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        while (pos >= 0) {
            if (m <= 0) {
                nums1[pos--] = nums2[(n--) - 1];
            }
            else if (n <= 0) {
                nums1[pos--] = nums1[(m--) - 1];
            }
            else if (nums1[m - 1] > nums2[n - 1]) {
                nums1[pos--] = nums1[(m--) - 1];
            }
            else {
                nums1[pos--] = nums2[(n--) - 1];
            }
        }
    }
}
