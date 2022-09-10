public class Problem69 {
    public String solve() {
        int x = 2147395599;
        return String.valueOf(mySqrt(x));
    }
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        else if (x < 4) {
            return 1;
        }
        else {
            return binSqrtSearch(x, x / 2, x / 2);
        }
    }
    private int binSqrtSearch(int x, int c, int i) {
        int a = x / c;
        int b = x / (c - 1);
        if (a == c) {
            return c;
        }
        else if (a < c && b >= (c - 1)) {
            return c - 1;
        }
        else if (a > c) {
            return binSqrtSearch(x, c + (i == 0 ? 1 : (i / 2)), i == 0 ? 1 : (i / 2));
        }
        else {
            return binSqrtSearch(x, c - (i == 0 ? 1 : (i / 2)), i == 0 ? 1 : (i / 2));
        }
    }
}
