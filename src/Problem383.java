import java.util.HashMap;

public class Problem383 {
    public String solve() {
        String ransomNote = "aa";
        String magazine = "a";
        return Boolean.toString(canConstruct(ransomNote, magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] chars = magazine.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : chars) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            }
            else {
                hm.put(c, 1);
            }
        }
        char[] noteChars = ransomNote.toCharArray();
        int val;
        for (char c : noteChars) {
            if (!hm.containsKey(c)) {
                return false;
            }
            val = hm.get(c) - 1;
            if (val < 0) {
                return false;
            }
            else {
                hm.put(c, val);
            }
        }
        return true;
    }
}
