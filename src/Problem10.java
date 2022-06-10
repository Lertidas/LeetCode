public class Problem10 {
    public String solve() {
        return Boolean.toString(isMatch("ab", ".*"));
    }
    public boolean isMatch(String s, String p) {
        int n1 = s.length();
        int n2 = p.length();
        int p1 = 0;
        int p2 = 0;
        while (p2 < n2) {
            // Handle multiple token
            if (p2 < n2 - 1 && p.charAt(p2 + 1) == '*') {
                // Recursively call
                for (int i = 0; i < n1 - p1 + 1; i++) {
                    if (isMatch(s.substring(p1), p.substring(p2, p2 + 1).repeat(i)
                            + p.substring(p2 + 2))) {
                        return true;
                    }
                }
                return false;
            }
            if (p1 < n1) {
                // Handle Wild
                if (p.charAt(p2) != '.') {
                    if (s.charAt(p1) != p.charAt(p2)) {
                        return false;
                    }
                }
                p1 += 1;
                p2 += 1;
            }
            else {
                break;
            }
        }
        return p1 >= n1 && p2 >= n2;
    }
}
