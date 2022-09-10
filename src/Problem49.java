import java.util.*;

public class Problem49 {
    public String solve() {
        String[] strs = new String[]{"a"};
//        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        return String.valueOf(groupAnagrams(strs));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] sorted = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            sorted[i] = getSortedString(strs[i]);
        }

        // Check if used
        HashMap<String, Integer> used = new HashMap<>();
        int count = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!used.containsKey(sorted[i])) {
                used.put(sorted[i], count);
                result.add(new ArrayList<>());
                result.get(count++).add(strs[i]);
            }
            else {
                result.get(used.get(sorted[i])).add(strs[i]);
            }
        }
        return result;
    }
    private String getSortedString(String s) {
        char[] sRep = s.toCharArray();
        Arrays.sort(sRep);
        return Arrays.toString(sRep);
    }
}
