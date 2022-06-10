import java.util.HashMap;

public class Problem3 {
    public String solve() {
        return Integer.toString(lengthOfLongestSubstring("abba"));
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
                int length = i - startIndex;
                if (length > maxLength) {
                    maxLength = length;
                }
                startIndex = hashMap.get(c) + 1;
                // Create new Hashmap to store passed over characters
                HashMap<Character, Integer> temp = new HashMap<>();
                for (Character character : hashMap.keySet()) {
                    if (hashMap.get(character) >= startIndex) {
                        temp.put(character, hashMap.get(character));
                    }
                }
                hashMap = temp;
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
