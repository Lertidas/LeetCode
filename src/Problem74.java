public class Problem74 implements Problem {
    @Override
    public String solve() {
//        int[][] matrix = new int[][]{new int[]{1,3,5,7},new int[]{10,11,16,20},new int[]{23,30,34,60}};
        int[][] matrix = new int[][]{new int[]{1, 1}};
        int target = 2;
        return String.valueOf(searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int size = matrix.length * matrix[0].length;
        if (size == 1) {
            return matrix[0][0] == target;
        }
        else {
            return matrixBinarySearch(matrix, target, 0, size - 1, size - 1);
        }
    }
    private boolean matrixBinarySearch(int[][] matrix, int target, int l, int r, int size) {
        int pos = l + ((r - l) / 2);
        int currentVal = matrix[pos / matrix[0].length][pos % matrix[0].length];
        // Check for zero case
        if (pos == size && target > currentVal) {
            return false;
        }
        else if (r - l == 1) {
            int rVal = matrix[(pos + 1) / matrix[0].length][(pos + 1) % matrix[0].length];
            if (rVal == target || currentVal == target) {
                return true;
            }
            else {
                return false;
            }
        }
        else if (pos == 0) {
            if (target == currentVal) {
                return true;
            }
            else if (target < currentVal) {
                return false;
            }
            else {
                return matrixBinarySearch(matrix, target, pos, r, size);
            }
        }
        else {
            if (target == currentVal) {
                return true;
            }
            else if (target < currentVal) {
                return matrixBinarySearch(matrix, target, l, pos, size);
            }
            else {
                return matrixBinarySearch(matrix, target, pos, r, size);
            }
        }
    }
}
