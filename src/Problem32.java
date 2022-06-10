import java.util.ArrayList;
import java.util.List;

public class Problem32 {
    public String solve() {
        String input = "";
        return Integer.toString(longestValidParentheses(input));
    }
    public int longestValidParentheses(String s) {
        // List of first cycled through strings
        List<String> strings = new ArrayList<>();
        int open = 0;
        int closed = 0;
        int start = 0;
        int n = s.length();
        // Go through front
        for (int i = 0; i < n; i++) {
            // Add to count
            if (s.charAt(i) == '(') {
                open += 1;
            }
            else {
                closed += 1;
            }
            // Check current state
            if (closed > open) {
                if (i > start) {
                    strings.add(s.substring(start, i));
                }
                start = i + 1;
                open = 0;
                closed = 0;
            }
        }
        if (start < n) {
            strings.add(s.substring(start));
        }
        // Variables
        int maxLength = 0;
        // Iterate through substrings backwards
        for (String string : strings) {
            int m = 0;
            int length = string.length();
            open = 0;
            closed = 0;
            for (int i = length - 1; i >= 0; i--) {
                // Add to count
                if (string.charAt(i) == '(') {
                    open += 1;
                }
                else {
                    closed += 1;
                }
                // Check current state
                if (open > closed) {
                    int v = closed * 2;
                    if (v > m) {
                        m = v;
                    }
                    open = 0;
                    closed = 0;
                }
            }
            int v = open * 2;
            if (v > m) {
                m = v;
            }
            if (m > maxLength) {
                maxLength = m;
            }
        }
        return maxLength;
    }
}
