public class Problem459 implements Problem {

    @Override
    public String solve() {
        String s = "aabaaba";
        return String.valueOf(repeatedSubstringPattern(s));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = 1;
        while (n < (s.length() / 2) + 1) {
            if (s.length() % n == 0) {
                String substring = s.substring(0, n);
                boolean flag = true;
                for (int i = n; i < s.length(); i += n) {
                    String compareSubstring = s.substring(i, i + n);
                    if (!substring.equals(compareSubstring)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
            n++;
        }
        return false;
    }
}
