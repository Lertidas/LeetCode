import java.util.HashSet;

public class Problem65 implements Problem{
    @Override
    public String solve() {
        String s = "99e2.5";
        return String.valueOf(isNumber(s));
    }
    public boolean isNumber(String s) {
        if (s.charAt(0) == 'e' || s.charAt(0) == 'E' ||
        s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == 'E') {
            return false;
        }
        HashSet<Character> digits = new HashSet<>();
        digits.add('0');
        digits.add('1');
        digits.add('2');
        digits.add('3');
        digits.add('4');
        digits.add('5');
        digits.add('6');
        digits.add('7');
        digits.add('8');
        digits.add('9');
        String[] results = s.split("[eE]");
        if (results.length == 1) {
            return (isDecimal(results[0], digits) || isInteger(results[0], digits));
        }
        else if (results.length == 2) {
            return ((isDecimal(results[0], digits) || isInteger(results[0], digits)) &&
                    isInteger(results[1], digits));
        }
        else {
            return false;
        }
    }
    private boolean isDecimal(String s, HashSet<Character> digits) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return false;
        }
        else if (s.length() == 1 && s.charAt(0) == '.') {
            return false;
        }
        else {
            char[] chars = s.toCharArray();
            boolean usedDecimal = false;
            for (Character c : chars) {
                if (!digits.contains(c) && (usedDecimal || c != '.')) {
                    return false;
                }
                else if (c == '.') {
                    usedDecimal = true;
                }
            }
            return true;
        }
    }
    private boolean isInteger(String s, HashSet<Character> digits) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        if (s.length() == 0) {
            return false;
        }
        else {
            char[] chars = s.toCharArray();
            for (Character c : chars) {
                if (!digits.contains(c)) {
                    return false;
                }
            }
            return true;
        }
    }
}
