import java.util.Arrays;

public class Problem59 {
    public String solve() {
        int n = 5;
        return Arrays.deepToString(generateMatrix(n));
    }
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }
        int l = 0;
        int r = n - 1;
        int u = 0;
        int d = n - 1;
        int count = 1;
        while (r - l > 1 && d - u > 1) {
            // Right
            for (int h = l; h <= r; h++) {
                matrix[u][h] = count++;
            }
            // Down
            for (int v = u + 1; v < d; v++) {
                matrix[v][r] = count++;
            }
            // Left
            for (int h = r; h >= l; h--) {
                matrix[d][h] = count++;
            }
            // Up
            for (int v = d - 1; v > u; v--) {
                matrix[v][l] = count++;
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
                matrix[u][h] = count++;
            }
        }
        else if (l == r) {
            // Add moving down only
            for (int v = u; v <= d; v++) {
                matrix[v][r] = count++;
            }
        }
        else if (r - l >= d - u) {
            // Right
            for (int h = l; h <= r; h++) {
                matrix[u][h] = count++;
            }
            // Left
            for (int h = r; h >= l; h--) {
                matrix[d][h] = count++;
            }
        }
        else {
            // Right
            for (int h = l; h <= r; h++) {
                matrix[u][h] = count++;
            }
            // Down + 1
            for (int v = u + 1; v <= d; v++) {
                matrix[v][r] = count++;
            }
            // Up + 1
            for (int v = d; v > u; v--) {
                matrix[v][l] = count++;
            }
        }
        return matrix;
    }
}
