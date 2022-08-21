public class Problem44 {
    public String solve() {
//        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
//        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb";
        String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";
        return String.valueOf(isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        char c = 'a';
        char d;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            d = p.charAt(i);
            if (!(d == '*' && c == '*')) {
                sb.append(d);
            }
            c = d;
        }
        return isMatchRecursive(s, sb.toString());
    }
    private boolean isMatchRecursive(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        else if (s.equals("")) {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }
        else if (p.equals("")) {
            return false;
        }
        char pChar = p.charAt(0);
        char sChar = s.charAt(0);
        switch (pChar) {
            case '?':
                return isMatchRecursive(s.substring(1), p.substring(1));
            case '*':
                for (int i = 0; i <= s.length(); i++) {
                    if (isSimpleStartingMatch(s.substring(i), getSimpleString(p.substring(1))) &&
                    isMatchRecursive(s.substring(i), p.substring(1))) {
                        return true;
                    }
                }
                return false;
            default:
                if (pChar == sChar) {
                    return isMatchRecursive(s.substring(1), p.substring(1));
                }
                else {
                    return false;
                }
        }
    }
    private String getSimpleString(String s) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '*') {
                return sb.toString();
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private boolean isSimpleStartingMatch(String s, String p) {
        if (p.length() > s.length()) {
            return false;
        }
        char a;
        char b;
        for (int i = 0; i < p.length(); i++) {
            a = s.charAt(i);
            b = p.charAt(i);
            if (b != '?' && b != a) {
                return false;
            }
        }
        return true;
    }
}
