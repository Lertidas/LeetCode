import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem51 {
    public String solve() {
        int n = 9;
        List<List<String>> lst = solveNQueens(n);
        return String.valueOf(lst);
    }
    public List<List<String>> solveNQueens(int n) {
        return new ArrayList<>(nQueens(getBoard(n), n, 0, new HashSet<>()));
    }
    private HashSet<List<String>> nQueens(List<String> board, int n, int queens, HashSet<String> used) {
        HashSet<List<String>> set = new HashSet<>();
        if (queens == n) {
            set.add(board);
            return set;
        }
        char c;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                c = board.get(y).charAt(x);
                if (c == '?' && !used.contains(getRepresentation(y, x))) {
                    used.add(getRepresentation(y, x));
                    List<String> newBoard = new ArrayList<>(board);
                    StringBuilder sb = new StringBuilder();
                    // Set row
                    for (int a = 0; a < n; a++) {
                        if (a == x) {
                            sb.append('Q');
                        }
                        else {
                            sb.append('.');
                        }
                    }
                    newBoard.set(y, sb.toString());
                    // Set column and diagonals
                    for (int a = 0; a < n; a++) {
                        if (a != y) {
                            int dist = Math.abs(y - a);
                            int left = x - dist;
                            int right = x + dist;
                            sb = new StringBuilder(board.get(a));
                            sb.setCharAt(x, '.');
                            if (left >= 0) {
                                sb.setCharAt(left, '.');
                            }
                            if (right < n) {
                                sb.setCharAt(right, '.');
                            }
                            newBoard.set(a, sb.toString());
                        }
                    }
                    // Add found values to hash set
                    HashSet<List<String>> results = nQueens(newBoard, n, queens + 1, new HashSet<>(used));
//                    for (List<String> result : results) {
//                        for (int y1 = 0; y1 < n; y1++) {
//                            for (int x1 = 0; x1 < n; x1++) {
//                                if (result.get(y1).charAt(x1) == 'Q') {
//                                    used.add(getRepresentation(y1, x1));
//                                }
//                            }
//                        }
//                    }
                    set.addAll(results);
                }
            }
        }
        return set;
    }
    private String getRepresentation(int y, int x) {
        return y + "-" + x;
    }
    private List<String> getBoard(int n) {
        List<String> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append("?");
            }
            lst.add(sb.toString());
        }
        return lst;
    }
}
