public class Problem72 implements Problem{
    @Override
    public String solve() {
        String word1 = "ab";
        String word2 = "a";
        return String.valueOf(minDistance(word1, word2));
    }
    public int minDistance(String word1, String word2) {

        if (word1.equals(word2)) {
            return 0;
        }
        else if (word1.equals("")) {
            return word2.length();
        }
        else if (word2.equals("")) {
            return word1.length();
        }

        int[][] result = new int[word1.length() + 1][];

        // Initialize base cases
        result[0] = new int[word2.length() + 1];
        for (int b = 0; b < result[0].length; b++) {
            result[0][b] = b;
        }
        for (int a = 1; a < result.length; a++) {
            result[a] = new int[result[0].length];
            result[a][0] = a;
        }

        // Set chars
        char c1;
        char c2;
        // Iterate dynamically through cases
        for (int a = 1; a < result.length; a++) {
            for (int b = 1; b < result[a].length; b++) {
                c1 = word1.charAt(word1.length() - a);
                c2 = word2.charAt(word2.length() - b);
                // Same Value
                if (c1 == c2) {
                    result[a][b] = result[a - 1][b - 1];
                }
                else {
                    result[a][b] = 1 + Math.min(
                            // Insert
                            result[a][b - 1],
                            Math.min(
                                    // Delete
                                    result[a - 1][b],
                                    // Replace
                                    result[a - 1][b - 1]
                            )
                    );
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
