public class Problem11 {
    public String solve() {
        int[] input = new int[]{1,8,6,2,5,4,8,3,7};
        return Integer.toString(maxArea(input));
    }
    public int maxArea(int[] height) {
        int length = height.length;
        int area = 0;
        for (int i = 0; i < length; i++) {
            int temp = maxSingleArea(i, height, length);
            if (temp > area) {
                area = temp;
            }
        }
        return area;
    }
    private int maxSingleArea(int a, int[] height, int length) {
        int h = height[a];
        int r = length - a;
        int l = a - Math.max(a, r);
        r = a + Math.max(a, r);
        while (r != a && l != a) {
            if (r < length && height[r] >= h) {
                return (r - a) * h;
            }
            else if (l >= 0 && height[l] >= h) {
                return (a - l) * h;
            }
            l += 1;
            r -= 1;
        }
        return 0;
    }
}
