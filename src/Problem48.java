import java.util.Arrays;

public class Problem48 {
    public String solve() {
        int[][] matrix = new int[3][];
        matrix[0] = new int[]{1, 2, 3};
        matrix[1] = new int[]{4, 5, 6};
        matrix[2] = new int[]{7, 8, 9};

//        int[][] matrix = new int[4][];
//        matrix[0] = new int[]{5, 1, 9, 11};
//        matrix[1] = new int[]{2, 4, 8, 10};
//        matrix[2] = new int[]{13, 3, 6, 7};
//        matrix[3] = new int[]{15, 14, 12, 16};

//        int[][] matrix = new int[4][];
//        matrix[0] = new int[]{1, 2, 3, 4};
//        matrix[1] = new int[]{5, 6, 7, 8};
//        matrix[2] = new int[]{9, 10, 11, 12};
//        matrix[3] = new int[]{13, 14, 15, 16};

//        int[][] matrix = new int[5][];
//        matrix[0] = new int[]{1, 2, 3, 4, 5};
//        matrix[1] = new int[]{6, 7, 8, 9, 10};
//        matrix[2] = new int[]{11, 12, 13, 14, 15};
//        matrix[3] = new int[]{16, 17, 18, 19, 20};
//        matrix[4] = new int[]{21, 22, 23, 24, 25};
        rotate(matrix);
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        return Arrays.toString(matrix);
    }
    public void rotate(int[][] matrix) {
        boolean odd = matrix.length % 2 != 0;
        int y1, y2, y3, y4, x1, x2, x3, x4, a, b, c, d;
        for (int y = 0; y < (matrix.length + 1) / 2; y++) {
            for (int x = y; x < matrix.length - y - 1; x++) {
                if (!(odd && y == ((matrix.length + 1) / 2) - 1 &&
                x == ((matrix.length + 1) / 2) - 1)) {
                    // Rotation Occurs
                    if (y == x) {
                        y1 = y;
                        x1 = x;
                        y2 = y;
                        x2 = matrix.length - x - 1;
                        y3 = matrix.length - y - 1;
                        x3 = matrix.length - x - 1;
                        y4 = matrix.length - y - 1;
                        x4 = x;
                    }
                    else {
                        y1 = y;
                        x1 = x;

                        y2 = x;
                        x2 = matrix.length - y - 1;

                        y3 = matrix.length - y - 1;
                        x3 = matrix.length - x - 1;

                        y4 = matrix.length - x - 1;
                        x4 = y;
                    }
                    // Use to adjust all values
                    a = matrix[y1][x1];
                    b = matrix[y2][x2];
                    c = matrix[y3][x3];
                    d = matrix[y4][x4];

                    matrix[y1][x1] = d;
                    matrix[y2][x2] = a;
                    matrix[y3][x3] = b;
                    matrix[y4][x4] = c;
                }
            }
        }
    }
}
