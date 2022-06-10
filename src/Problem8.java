import java.util.HashSet;

public class Problem8 {
    public String solve() {
        return Integer.toString(myAtoi("  0000000000012345678"));
    }
    public int myAtoi(String s) {
        int n = s.length();
        int p = 0;
        int start;
        boolean flag = false;
        HashSet<Character> validChar = new HashSet<>(10);
        validChar.add('0');
        validChar.add('1');
        validChar.add('2');
        validChar.add('3');
        validChar.add('4');
        validChar.add('5');
        validChar.add('6');
        validChar.add('7');
        validChar.add('8');
        validChar.add('9');
        char[] posMax = new char[]{'2', '1', '4', '7', '4', '8', '3', '6', '4', '7'};
        char[] negMax = new char[]{'2', '1', '4', '7', '4', '8', '3', '6', '4', '8'};
        // Remove leading whitespace
        while (p < n && s.charAt(p) == ' ') {
            p += 1;
        }
        if (p < n) {
            // Check for sign
            if (s.charAt(p) == '-') {
                flag = true;
                p += 1;
            }
            else if (s.charAt(p) == '+') {
                p += 1;
            }
            start = p;
            int leadingZeros = 0;
            boolean seenNonZero = false;
            // Loop through while valid chars
            while (p < n && validChar.contains(s.charAt(p))) {
                if (!seenNonZero) {
                    if (s.charAt(p) == '0') {
                        leadingZeros += 1;
                    }
                    else {
                        seenNonZero = true;
                    }
                }
                p += 1;
            }
            // Return if start - p = 0 meaning no valid int values
            if (p - start == 0) {
                return 0;
            }
            // Convert to int
            else if (p - start - leadingZeros > 10) {
                if (flag) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }
            // Check for size
            else if (p - start - leadingZeros == 10) {
                if (flag) {
                    for (int i = 0; i < 10; i++) {
                        if (s.charAt(start + i) < negMax[i]) {
                            break;
                        }
                        else if (s.charAt(start + i) > negMax[i]) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                else {
                    for (int i = 0; i < 10; i++) {
                        if (s.charAt(start + i) < posMax[i]) {
                            break;
                        }
                        else if (s.charAt(start + i) > posMax[i]) {
                            return Integer.MAX_VALUE;
                        }
                    }
                }
            }
            if (flag) {
                return Integer.parseInt("-" + s.substring(start, p));
            }
            else {
                return Integer.parseInt(s.substring(start, p));
            }
        }
        return 0;
    }
}
