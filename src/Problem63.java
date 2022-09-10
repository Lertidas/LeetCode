import java.util.HashMap;

public class Problem63 implements Problem{
    @Override
    public String solve() {
        int[][] obstacleGrid = new int[2][];
//        obstacleGrid[0] = new int[]{0, 0, 0};
//        obstacleGrid[1] = new int[]{0, 1, 0};
//        obstacleGrid[2] = new int[]{0, 0, 0};
        obstacleGrid[0] = new int[]{0, 1};
        obstacleGrid[1] = new int[]{0, 0};
        return String.valueOf(uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        HashMap<String, Integer> movesMap = new HashMap<>();
        int result;
        for (int m0 = 1; m0 <= m; m0++) {
            for (int n0 = 1; n0 <= n; n0++) {
                // 1 case
                if (m0 == 1) {
                    if (n0 == 1) {
                        movesMap.put(getRepresentation(m0, n0),
                                obstacleGrid[m0 - 1][n0 - 1] == 1 ? 0 : 1);
                    }
                    else {
                        movesMap.put(getRepresentation(m0, n0),
                                obstacleGrid[m0 - 1][n0 - 1] == 1 ? 0 : movesMap.get(
                                        getRepresentation(m0, n0 - 1)
                                ));
                    }
                }
                else if (n0 == 1) {
                    movesMap.put(getRepresentation(m0, n0),
                            obstacleGrid[m0 - 1][n0 - 1] == 1 ? 0 : movesMap.get(
                                    getRepresentation(m0 - 1, n0)
                            ));
                }
                else {
                    result = movesMap.get(getRepresentation(m0 - 1, n0))
                            + movesMap.get(getRepresentation(m0, n0 - 1));
                    movesMap.put(getRepresentation(m0, n0),
                            obstacleGrid[m0 - 1][n0 - 1] == 1 ? 0 : result);
                }
            }
        }
        return movesMap.get(getRepresentation(m, n));
    }
    private String getRepresentation(int m, int n) {
        return m + "-" + n;
    }
}
