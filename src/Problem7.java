public class Problem7 {
    public String solve() {
        return Integer.toString(reverse(1534236469));
    }
    public int reverse(int x) {
        int y = 0;
        int divisor = 1;
        int count = 0;
        int[] posMax = new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 7};
        int[] negMax = new int[]{2, 1, 4, 7, 4, 8, 3, 6, 4, 8};
        // Get initial divisor
        while (count < 9 && Math.abs(x) >= divisor * 10) {
            divisor *= 10;
            count += 1;
        }
        if (count > 9) {
            return 0;
        }
        else if (count == 9) {
            int test = x;
            int testDivisor = 10;
            int v;
            // Check for too large value
            if (x > 0) {
                for (int i = 0; i < 10; i++) {
                    v = (test % testDivisor) / (testDivisor / 10);
                    if (v > posMax[i]) {
                        return 0;
                    }
                    else if (v < posMax[i]) {
                        break;
                    }
                    testDivisor *= 10;
                }
            }
            // Check for too small value
            else {
                test = x * -1;
                for (int i = 0; i < 10; i++) {
                    v = (test % testDivisor) / (testDivisor / 10);
                    if (v > negMax[i]) {
                        return 0;
                    }
                    else if (v < negMax[i]) {
                        break;
                    }
                    testDivisor *= 10;
                }
            }
        }
        // Using divisor, flip number
        count = 1;
        while (Math.abs(x) > 0) {
            y += (x / divisor) * count;
            x %= divisor;
            divisor /= 10;
            count *= 10;
        }
        return y;
    }
}
