public class Problem58 {
    public String solve() {
        String s = "   fly me   to   the moon  ";
        return String.valueOf(lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s) {
        int longest = 0;
        boolean started = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (started) {
                if (s.charAt(i) == ' ') {
                    return longest;
                }
                else {
                    longest += 1;
                }
            }
            else {
                if (s.charAt(i) != ' ') {
                    started = true;
                    longest += 1;
                }
            }
        }
        return longest;
    }
}
