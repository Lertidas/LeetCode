import java.util.HashMap;
import java.util.HashSet;

public class Problem36 {
    public String solve() {
        char[] r0 = new char[]{'5','3','.','.','7','.','.','.','.'};
        char[] r1 = new char[]{'6','.','.','1','9','5','.','.','.'};
        char[] r2 = new char[]{'.','9','8','.','.','.','.','6','.'};
        char[] r3 = new char[]{'8','.','.','.','6','.','.','.','3'};
        char[] r4 = new char[]{'4','.','.','8','.','3','.','.','1'};
        char[] r5 = new char[]{'7','.','.','.','2','.','.','.','6'};
        char[] r6 = new char[]{'.','6','.','.','.','.','2','8','.'};
        char[] r7 = new char[]{'.','.','.','4','1','9','.','.','5'};
        char[] r8 = new char[]{'.','.','.','.','8','.','.','7','9'};
        char[][] board = new char[][] {r0, r1, r2, r3, r4, r5, r6, r7, r8};
        return String.valueOf(isValidSudoku(board));
    }
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> values;
        // Rows
        for (char[] row : board) {
            values = new HashSet<>();
            for (char c : row) {
                if (values.contains(c)) {
                    return false;
                }
                else if (c != '.'){
                    values.add(c);
                }
            }
        }
        // Columns
        for (int i = 0; i < 9; i++) {
            values = new HashSet<>();
            for (char[] row : board) {
                if (values.contains(row[i])) {
                    return false;
                }
                else if (row[i] != '.'){
                    values.add(row[i]);
                }
            }
        }
        int highI;
        int highJ;
        // Boxes
        for (int i = 0; i < 9; i += 3) {
            highI = i + 3;
            for (int j = 0; j < 9; j += 3) {
                // Check boxes
                highJ = j + 3;
                values = new HashSet<>();
                for (int a = i; a < highI; a++) {
                    for (int b = j; b < highJ; b++) {
                        if (values.contains(board[a][b])) {
                            return false;
                        }
                        else if (board[a][b] != '.'){
                            values.add(board[a][b]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
