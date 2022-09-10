import java.util.ArrayList;
import java.util.List;

public class Problem54 {
    public String solve() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3, 4};
        matrix[1] = new int[]{5, 6, 7, 8};
        matrix[2] = new int[]{9, 10, 11, 12};

//        int[][] matrix = new int[2][];
//        matrix[0] = new int[]{3};
//        matrix[1] = new int[]{2};
        return spiralOrder(matrix).toString();
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        while (r - l > 1 && d - u > 1) {
            // Right
            for (int h = l; h <= r; h++) {
                spiral.add(matrix[u][h]);
            }
            // Down
            for (int v = u + 1; v < d; v++) {
                spiral.add(matrix[v][r]);
            }
            // Left
            for (int h = r; h >= l; h--) {
                spiral.add(matrix[d][h]);
            }
            // Up
            for (int v = d - 1; v > u; v--) {
                spiral.add(matrix[v][l]);
            }
            l += 1;
            r -= 1;
            u += 1;
            d -= 1;
        }
        // Solve for final
        if (u == d) {
            // Add moving right only
            for (int h = l; h <= r; h++) {
                spiral.add(matrix[u][h]);
            }
        }
        else if (l == r) {
            // Add moving down only
            for (int v = u; v <= d; v++) {
                spiral.add(matrix[v][r]);
            }
        }
        else if (r - l >= d - u) {
            // Right
            for (int h = l; h <= r; h++) {
                spiral.add(matrix[u][h]);
            }
            // Left
            for (int h = r; h >= l; h--) {
                spiral.add(matrix[d][h]);
            }
        }
        else {
            // Right
            for (int h = l; h <= r; h++) {
                spiral.add(matrix[u][h]);
            }
            // Down + 1
            for (int v = u + 1; v <= d; v++) {
                spiral.add(matrix[v][r]);
            }
            // Up + 1
            for (int v = d; v > u; v--) {
                spiral.add(matrix[v][l]);
            }
        }
        return spiral;
    }
}
