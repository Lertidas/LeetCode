public class Problem50 {
    public String solve() {
        double x = 2.00000;
        int n = -2147483648;
        return String.valueOf(myPow(x, n));
    }
    public double myPow(double x, int n) {
        double a;
        if (x == 0) {
            return 0;
        }
        else if (x == 1) {
            return 1;
        }
        else if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1.0 / (myPow(x, -(n + 1)) * x);
            }
            else {
                return 1.0 / myPow(x, -n);
            }
        }
        else if (n == 0) {
            return 1.0;
        }
        else if (n == 1) {
            return x;
        }
        else if (n == 2) {
            return x * x;
        }
        else if (n % 2 == 0) {
            a = myPow(x, n / 2);
            return a * a;
        }
        else {
            return x * myPow(x, n - 1);
        }
    }
}
