public class Problem6 {
    public String solve() {
        return convert("PAYPALISHIRING", 5);
    }
    public String convert(String s, int numRows) {
        int n = s.length();
        // If string length is less than numRows return string
        if (n <= numRows) {
            return s;
        }
        int modFactor = 2 * numRows - 2;
        // Mod Factor is 0, meaning no diagonal rows, simply return string
        if (modFactor == 0) {
            return s;
        }
        StringBuilder result = new StringBuilder();
        int b, c;
        // Standard string where length is greater than mod factor
        if (n >= modFactor) {
            for (int a = 0; a < (modFactor / 2) + 1; a++) {
                if (a == 0 || a == (modFactor / 2)) {
                    // Add every row
                    for (int i = a; i < n; i += modFactor) {
                        result.append(s.charAt(i));
                    }
                }
                else {
                    b = a;
                    c = modFactor - a;
                    while (b < n && c < n) {
                        // Add first row
                        result.append(s.charAt(b));
                        // Add second row
                        result.append(s.charAt(c));
                        b += modFactor;
                        c += modFactor;
                    }
                    if (b < n) {
                        result.append(s.charAt(b));
                    }
                    else if (c < n) {
                        result.append(s.charAt(c));
                    }
                }
            }
        }
        // Case where string length is less than mod factor
        else {
            int j;
            int loopingTo = n;
            for (int i = 0; i < loopingTo; i++) {
                j = modFactor - i;
                result.append(s.charAt(i));
                if (j < n && j != numRows - 1) {
                    result.append(s.charAt(j));
                    loopingTo -= 1;
                }
            }
        }
        return result.toString();
    }
}
