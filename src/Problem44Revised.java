public class Problem44Revised {
    public String solve() {
        String s = "aa";
        String p = "a*";
        return String.valueOf(isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        else if (p.equals("")) {
            return false;
        }
        char c = 'a';
        char d;
        boolean right = false;
        boolean left = false;
        String initialS = s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            d = p.charAt(i);
            if (!(d == '*' && c == '*')) {
                sb.append(d);
            }
            c = d;
        }
        p = sb.toString();
        if (p.charAt(p.length()-1) == '*') {
            right = true;
            if (p.length() > 1) {
                p = p.substring(0, p.length() - 1);
            }
        }
        if (p.charAt(0) == '*') {
            left = true;
            if (p.length() > 1) {
                p = p.substring(1);
            }
        }
        String[] strings = p.split("\\*");
        int pos;
        for (String str : strings) {
            pos = findFirstMatch(s, str);
            if (pos == -1) {
                return false;
            }
            else {
                s = s.substring(pos);
            }
        }
        if ((left || matchesStart(initialS, strings[0])) &&
                (right || matchesEnd(initialS, strings[strings.length-1]))) {
            if (!right && !left && strings.length == 1 && initialS.length() != p.length()) {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            return false;
        }
    }
    private boolean matchesStart(String s, String p) {
        if (p.length() > s.length()) {
            return false;
        }
        else {
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) != '?' && p.charAt(i) != s.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
    private boolean matchesEnd(String s, String p) {
        if (p.length() > s.length()) {
            return false;
        }
        else {
            char c;
            for (int i = 0; i < p.length(); i++) {
                c = p.charAt(p.length() - i - 1);
                if (c != '?' && c != s.charAt(s.length() - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
    private int findFirstMatch(String s, String p) {
        if (p.length() > s.length()) {
            return -1;
        }
        else {
            boolean flag;
            for (int i = 0; i <= s.length() - p.length(); i++) {
                flag = true;
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) != '?' && s.charAt(i + j) != p.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i + p.length();
                }
            }
        }
        return -1;
    }
}
