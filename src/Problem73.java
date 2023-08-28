import java.util.Arrays;
import java.util.HashSet;

public class Problem73 implements Problem{
    @Override
    public String solve() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{0, 1, 2, 0};
        matrix[1] = new int[]{3, 4, 5, 2};
        matrix[2] = new int[]{1, 3, 1, 5};
        setZeroes(matrix);

        StringBuilder returnString = new StringBuilder();
        for (int[] row : matrix) {
            returnString.append(Arrays.toString(row));
            returnString.append("\n");
        }
        return returnString.toString();
    }
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> x = new HashSet<>();
        HashSet<Integer> y = new HashSet<>();
        // Populate set with values to adjust to zero
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        // Adjust zeroes where needed
        for (Integer xLocation : x) {
            Arrays.fill(matrix[xLocation], 0);
        }
        for (Integer yLocation : y) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][yLocation] = 0;
            }
        }
    }
}
