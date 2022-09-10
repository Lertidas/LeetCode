import java.util.HashMap;

public class Problem64 implements Problem{
    @Override
    public String solve() {
        int[][] grid = new int[3][];
        grid[0] = new int[]{1, 3, 1};
        grid[1] = new int[]{1, 5, 1};
        grid[2] = new int[]{4, 2, 1};
        return String.valueOf(minPathSum(grid));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        HashMap<String, Integer> movesMap = new HashMap<>();
        int resultA;
        int resultB;
        int tileValue;
        for (int m0 = 1; m0 <= m; m0++) {
            for (int n0 = 1; n0 <= n; n0++) {
                tileValue = grid[m0 - 1][n0 - 1];
                // 1 case
                if (m0 == 1) {
                    if (n0 == 1) {
                        movesMap.put(getRepresentation(m0, n0), tileValue);
                    }
                    else {
                        movesMap.put(getRepresentation(m0, n0),
                                tileValue + movesMap.get(getRepresentation(m0, n0 - 1)));
                    }
                }
                else if (n0 == 1) {
                    movesMap.put(getRepresentation(m0, n0),
                            tileValue + movesMap.get(getRepresentation(m0 - 1, n0)));
                }
                else {
                    resultA = movesMap.get(getRepresentation(m0 - 1, n0));
                    resultB = movesMap.get(getRepresentation(m0, n0 - 1));
                    movesMap.put(getRepresentation(m0, n0), tileValue + Math.min(resultA, resultB));
                }
            }
        }
        return movesMap.get(getRepresentation(m, n));
    }
    private String getRepresentation(int m, int n) {
        return m + "-" + n;
    }
}
