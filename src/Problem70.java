public class Problem70 {
    public String solve() {
        int n = 3;
        return String.valueOf(climbStairs(n));
    }
    // Original Solution

    /*
    public int climbStairs(int n) {
        int[] stairs = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) {
                stairs[i] = i + 1;
            }
            else {
                stairs[i] = stairs[i - 1] + stairs[i - 2];
            }
        }
        return stairs[n - 1];
    }
    */

    // Alt solution
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        int c = n;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
