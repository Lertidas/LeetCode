import java.util.HashMap;

public class Problem62 {
    public String solve() {
        int m = 3;
        int n = 7;
        return String.valueOf(uniquePaths(m, n));
    }
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> hm = new HashMap<>();
        return traverse(1, 1, m, n, hm);
    }
    private int traverse(int y, int x, int m, int n, HashMap<String, Integer> hm) {
        if (y == m || x == n) {
            return 1;
        }
        else {
            String rep = repr(m - y, n - x);
            if (hm.containsKey(rep)) {
                return hm.get(rep);
            }
            int result = traverse(y + 1, x, m, n, hm) + traverse(y, x + 1, m, n, hm);
            hm.put(rep, result);
            return result;
        }
    }
    private String repr(int y, int x) {
        if (y < x) {
            return y + "+" + x;
        }
        else {
            return x + "+" + y;
        }
    }
}
