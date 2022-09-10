import java.util.Arrays;

public class Problem66 {
    public String solve() {
        int[] digits = new int[]{9, 9, 9, 9};
        return Arrays.toString(plusOne(digits));
    }
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int[] toReturn = new int[digits.length + 1];
        toReturn[0] = 1;
        return toReturn;
    }
}
