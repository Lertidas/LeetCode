import java.util.HashMap;

public class Problem62Revised implements Problem{
    @Override
    public String solve() {
        return String.valueOf(uniquePaths(3, 7));
    }
    public int uniquePaths(int m, int n) {
        HashMap<String, Integer> movesMap = new HashMap<>();
        int result;
        for (int m0 = 1; m0 <= m; m0++) {
            for (int n0 = 1; n0 <= n; n0++) {
                // 1 case
                if (m0 == 1 || n0 == 1) {
                    movesMap.put(getRepresentation(m0, n0), 1);
                }
                else {
                    result = movesMap.get(getRepresentation(m0 - 1, n0))
                            + movesMap.get(getRepresentation(m0, n0 - 1));
                    movesMap.put(getRepresentation(m0, n0), result);
                }
            }
        }
        return movesMap.get(getRepresentation(m, n));
    }
    private String getRepresentation(int m, int n) {
        return m < n ? m + "-" + n : n + "-" + m;
    }
}
