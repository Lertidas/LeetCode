import java.util.HashMap;

public class Problem9 {
    public String solve() {
        return Boolean.toString(isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
        // Take out negative and leading zero cases
        if (x < 0) {
            return false;
        }
        else {
            // Setup hashmap for divisors
            HashMap<Integer, Integer> digitMap = new HashMap<>();
            // Get digits
            int digits = 1;
            int divisor = 10;
            int test = x / divisor;
            digitMap.put(0, 1);
            while (test > 0) {
                digitMap.put(digits, divisor);
                divisor *= 10;
                digits += 1;
                test /= 10;
            }
            // Return True for 1 digit
            if (digits == 1) {
                return true;
            }
            // Handle trailing zeroes
            else if (x % 10 == 0) {
                return false;
            }
            for (int i = 0; i < digits / 2; i++) {
                int j = digits - i - 1;
                int a = (x / digitMap.get(j)) % 10;
                int b = (x / digitMap.get(i)) % 10;
                if (a != b) {
                    return false;
                }
            }
            return true;
        }
    }
}
