import java.util.*;

public class Problem30 {
    public String solve() {
        String s = "aaaaaaaaaaaaaa";
        String[] words = new String[]{"aa","aa"};
        return findSubstring(s, words).toString();
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        // Create HashMap for words
        HashMap<String, Integer> wordsSet = new HashMap<>();
        for (String toAdd : words) {
            if (wordsSet.containsKey(toAdd)) {
                wordsSet.put(toAdd, wordsSet.get(toAdd) + 1);
            } else {
                wordsSet.put(toAdd, 1);
            }
        }
        HashMap<String, Integer> used = new HashMap<>();
        int m = s.length();
        int n = words[0].length();
        int counter;
        for (int i = 0; i < (m - (n * words.length)) + 1; i++) {
            String sub = s.substring(i, i + n);
            // Reset HashMap
            used.clear();
            for (String key : wordsSet.keySet()) {
                if (!used.containsKey(key)) {
                    used.put(key, 0);
                }
            }
            if (wordsSet.containsKey(sub)) {
                counter = 1;
                used.put(sub, 1);
                for (int a = i + n; a < m ; a += n) {
                    if (counter == words.length) {
                        break;
                    }
                    String sub2 = s.substring(a, a + n);
                    if (wordsSet.containsKey(sub2)) {
                        // Loop through indexes
                        if (used.get(sub2) < wordsSet.get(sub2)) {
                            used.put(sub2, used.get(sub2) + 1);
                            counter += 1;
                        }
                        else {
                            break;
                        }
                    }
                    else {
                        break;
                    }
                }
                if (counter == words.length) {
                    result.add(i);
                }
            }
        }
        return result;
    }
}
