public class Problem11Revised {
    public String solve() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        return Integer.toString(maxArea(input));
    }
    public int maxArea(int[] height) {
        int length = height.length;
        int l = 0;
        int r = length - 1;
        int area = 0;
        int temp;
        while (l != r) {
            if (height[l] < height[r]) {
                // Check to update area
                temp = height[l] * (r - l);
                if (temp > area) {
                    area = temp;
                }
                l += 1;
            }
            else {
                // Check to update area
                temp = height[r] * (r - l);
                if (temp > area) {
                    area = temp;
                }
                r -= 1;
            }
        }
        return area;
    }
}
