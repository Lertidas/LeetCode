public class Problem14 {
    public String solve() {
        String[] input = new String[]{"dog","racecar","car"};
        return longestCommonPrefix(input);
    }
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int l = strs[0].length();
        char c;
        while (i < l) {
            c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
            i += 1;
        }
        return result.toString();
    }
}
