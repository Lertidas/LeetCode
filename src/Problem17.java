import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem17 {
    public String solve() {
        return letterCombinations("2").toString();
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        HashMap<Character, char[]> converter = new HashMap<>();
        converter.put('2', new char[]{'a', 'b', 'c'});
        converter.put('3', new char[]{'d', 'e', 'f'});
        converter.put('4', new char[]{'g', 'h', 'i'});
        converter.put('5', new char[]{'j', 'k', 'l'});
        converter.put('6', new char[]{'m', 'n', 'o'});
        converter.put('7', new char[]{'p', 'q', 'r', 's'});
        converter.put('8', new char[]{'t', 'u', 'v'});
        converter.put('9', new char[]{'w', 'x', 'y', 'z'});
        addValues(digits, "", result, converter);
        return result;
    }
    private void addValues(String digits, String s, List<String> list,
                           HashMap<Character, char[]> converter) {
        if (digits.length() > 0) {
            char[] chars = converter.get(digits.charAt(0));
            for (char c : chars) {
                addValues(digits.substring(1), s + c, list, converter);
            }
        }
        else {
            if (!s.equals("")) {
                list.add(s);
            }
        }
    }
}
