public class Problem12 {
    public String solve() {
        return intToRoman(1994);
    }
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        // Character representation for english and roman numbers
        int[] english = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
        "V", "IV", "I"};

        // Loop through num and update roman number
        for (int i = 0; i < english.length; i++) {
            while (num >= english[i]) {
                num -= english[i];
                result.append(roman[i]);
            }
        }
        return result.toString();
    }
}
