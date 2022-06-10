import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Problem3Revised {
    public String solve() {
        return Integer.toString(lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int startIndex = 0;
        int maxLength = 0;
        // Loop through string once
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                if (hashMap.get(c) >= startIndex) {
                    // Reset counter
                    int length = i - startIndex;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    startIndex = hashMap.get(c) + 1;
                }
                hashMap.put(c, i);
            }
            else {
                hashMap.put(c, i);
            }
        }
        // Check final substring
        int length = stringLength - startIndex;
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }
}
