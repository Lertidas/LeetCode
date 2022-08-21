public class Problem38 {
    public String solve() {
        int n = 4;
        return countAndSay(n);
    }
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        else {
            return say(countAndSay(n - 1));
        }
    }
    public String say(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count += 1;
            }
            else {
                stringBuilder.append(count);
                stringBuilder.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(c);
        return stringBuilder.toString();
    }
}
