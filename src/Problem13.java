import java.util.HashMap;

public class Problem13 {
    public String solve() {
        return Integer.toString(romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        // Character representation for english and roman numbers
        HashMap<String, Integer> conversion = new HashMap<>();
        conversion.put("M", 1000);
        conversion.put("CM", 900);
        conversion.put("D", 500);
        conversion.put("CD", 400);
        conversion.put("C", 100);
        conversion.put("XC", 90);
        conversion.put("L", 50);
        conversion.put("XL", 40);
        conversion.put("X", 10);
        conversion.put("IX", 9);
        conversion.put("V", 5);
        conversion.put("IV", 4);
        conversion.put("I", 1);

        // Loop trough and convert to int
        int pos = 0;
        while (pos < length) {
            if (pos + 1 < length && conversion.containsKey(s.substring(pos, pos + 2))) {
                result += conversion.get(s.substring(pos, pos + 2));
                pos += 2;
            }
            else {
                result += conversion.get(s.substring(pos, pos + 1));
                pos += 1;
            }
        }
        return result;
    }
}