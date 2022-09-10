import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Problem52 {
    public String solve() {
        int n = 9;
        return String.valueOf(totalNQueens(n));
    }
    public int totalNQueens(int n) {
        HashSet<Board> temp = nQueens(new Board(n));
        return temp.size();
    }
    private HashSet<Board> nQueens(Board board) {
        HashSet<Board> temp = new HashSet<>();
        if (board.isFinished()) {
            temp.add(board);
            return temp;
        }
        for (int x = 0; x < board.n; x++) {
            if (board.getTile(board.queens, x).isOpen()) {
                Board b1 = new Board(board);
                b1.placeQueen(board.queens, x);
                temp.addAll(nQueens(b1));
            }
        }
        return temp;
    }
    private class Tile {
        private int y;
        private int x;
        private char value;
        public Tile(int y, int x, char value) {
            this.y = y;
            this.x = x;
            this.value = value;
        }
        public char getValue() {
            return this.value;
        }
        public boolean isOpen() {
            return this.value == '?';
        }
        public boolean isQueen() {
            return this.value == 'Q';
        }
        public void setQueen() {
            this.value = 'Q';
        }
        public void setOpen() {
            this.value = '?';
        }
        public void setClosed() {
            this.value = '.';
        }
        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != Tile.class) {
                return false;
            }
            Tile t = (Tile) obj;
            return x == t.x && y == t.y && value == t.value;
        }
    }
    private class Board {
        private int n;
        private int queens;
        private Tile[][] tiles;
        public Board(Board b) {
            this.n = b.n;
            this.queens = b.queens;
            tiles = new Tile[n][];
            for (int y = 0; y < n; y++) {
                Tile[] temp = new Tile[n];
                for (int x = 0; x < n; x++) {
                    temp[x] = new Tile(y, x, b.getTile(y, x).getValue());
                }
                tiles[y] = temp;
            }
        }
        public Board(int n) {
            this.n = n;
            this.queens = 0;
            tiles = new Tile[n][];
            for (int y = 0; y < n; y++) {
                Tile[] temp = new Tile[n];
                for (int x = 0; x < n; x++) {
                    temp[x] = new Tile(y, x, '?');
                }
                tiles[y] = temp;
            }
        }
        public List<String> toStringList() {
            List<String> temp = new ArrayList<>();
            StringBuilder sb;
            for (int y = 0; y < n; y++) {
                sb = new StringBuilder();
                for (int x = 0; x < n; x++) {
                    sb.append(getTile(y, x).getValue());
                }
                temp.add(sb.toString());
            }
            return temp;
        }
        public boolean isFinished() {
            return n == queens;
        }
        public Tile getTile(int y, int x) {
            return tiles[y][x];
        }
        public void placeQueen(int y, int x) {
            for (int a = 0; a < n; a++) {
                if (a == y) {
                    // Set row
                    for (int b = 0; b < n; b++) {
                        if (b == x) {
                            getTile(a, b).setQueen();
                            queens += 1;
                        }
                        else {
                            getTile(a, b).setClosed();
                        }
                    }
                }
                else {
                    // Set column and diagonals
                    for (int b = 0; b < n; b++) {
                        if (b == x || (Math.abs(a - y)) == (Math.abs(b - x))) {
                            getTile(a, b).setClosed();
                        }
                    }
                }
            }
        }
        @Override
        public int hashCode() {
            return Objects.hash((Object) tiles);
        }
        @Override
        public boolean equals(Object obj) {
            if (obj.getClass() != Board.class) {
                return false;
            }
            Board b = (Board) obj;
            if (n != b.n || queens != b.queens) {
                return false;
            }
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (!(getTile(y, x).equals(b.getTile(y, x)))) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
