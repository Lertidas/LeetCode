public class Problem28 {
    public String solve() {
        String haystack = "aaaaaaaabc";
        String needle = "bc";
        return Integer.toString(strStr(haystack, needle));
    }
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        else {
            char c = needle.charAt(0);
            int n = needle.length();
            int m = haystack.length();
            for (int i = 0; i < (m - n) + 1; i++) {
                if (c == haystack.charAt(i) && needle.equals(haystack.substring(i, i + n))) {
                    return i;
                }
            }
            return -1;
        }
    }
}
