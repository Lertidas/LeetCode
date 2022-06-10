import java.util.ArrayList;
import java.util.List;

public class Problem29 {
    public String solve() {
        int dividend = 10;
        int divisor = Integer.MAX_VALUE;
        return Integer.toString(divide(dividend, divisor));
    }
    public int divide(int dividend, int divisor) {
        // Setup flags for negative and positive results
        boolean flag = dividend < 0 && divisor >= 0 || dividend >= 0 && divisor < 0;
        // Handle case where divisor is MIN_VAL
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dividend < 0) {
            divisor = Math.abs(divisor);
            if (divisor == 1) {
                if (flag) {
                    return dividend;
                }
                else {
                    if (dividend == Integer.MIN_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    else {
                        return -dividend;
                    }
                }
            }
            divisor = -divisor;
            if (divisor == dividend) {
                if (flag) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            List<Integer> dividers = new ArrayList<>();
            int d = divisor;
            while (d > dividend) {
                dividers.add(d);
                if (d >= dividend - d) {
                    d += d;
                }
                else {
                    break;
                }
            }
            int n = dividers.size();
            int[] countAdder = new int[n];
            int a = 1;
            for (int i = 0; i < n; i++) {
                countAdder[i] = a;
                a += a;
            }
            int count = 0;
            // Use dividers list to calculate count
            for (int i = n - 1; i >= 0; i--) {
                while (dividend <= dividers.get(i)) {
                    dividend -= dividers.get(i);
                    count += countAdder[i];
                }
                if (dividend == 0) {
                    if (flag) {
                        return -count;
                    }
                    else {
                        return count;
                    }
                }
            }
            if (flag) {
                return -count;
            }
            else {
                return count;
            }
        }
        else {
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            if (divisor == 1) {
                if (flag) {
                    return -dividend;
                }
                else {
                    return dividend;
                }
            }
            else if (divisor == dividend) {
                if (flag) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
            List<Integer> dividers = new ArrayList<>();
            int d = divisor;
            while (d < dividend) {
                dividers.add(d);
                if (d <= dividend - d) {
                    d += d;
                }
                else {
                    break;
                }
            }
            int n = dividers.size();
            int[] countAdder = new int[n];
            int a = 1;
            for (int i = 0; i < n; i++) {
                countAdder[i] = a;
                a += a;
            }
            int count = 0;
            // Use dividers list to calculate count
            for (int i = n - 1; i >= 0; i--) {
                while (dividend >= dividers.get(i)) {
                    dividend -= dividers.get(i);
                    count += countAdder[i];
                }
                if (dividend == 0) {
                    if (flag) {
                        return -count;
                    }
                    else {
                        return count;
                    }
                }
            }
            if (flag) {
                return -count;
            }
            else {
                return count;
            }
        }
    }
}
