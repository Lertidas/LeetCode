import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem37Alt {
    public String solve() {
        char[] r0 = new char[]{'.','.','9','7','4','8','.','.','.'};
        char[] r1 = new char[]{'7','.','.','.','.','.','.','.','.'};
        char[] r2 = new char[]{'.','2','.','1','.','9','.','.','.'};
        char[] r3 = new char[]{'.','.','7','.','.','.','2','4','.'};
        char[] r4 = new char[]{'.','6','4','.','1','.','5','9','.'};
        char[] r5 = new char[]{'.','9','8','.','.','.','3','.','.'};
        char[] r6 = new char[]{'.','.','.','8','.','3','.','2','.'};
        char[] r7 = new char[]{'.','.','.','.','.','.','.','.','6'};
        char[] r8 = new char[]{'.','.','.','2','7','5','9','.','.'};
        char[][] board = new char[][] {r0, r1, r2, r3, r4, r5, r6, r7, r8};
        solveSudoku(board);
        for (char[] a : board) {
            System.out.println(a);
        }
        return Arrays.toString(board);
    }
    public void solveSudoku(char[][] board) {
        SudokuBoard sudokuBoard = solveSudoku(new SudokuBoard(board));
        sudokuBoard.getCharRepresentation(board);
    }
    public SudokuBoard solveSudoku(SudokuBoard board) {
        SudokuBoard previous = null;
        while (!board.equals(previous)) {
            // Copy over previous
            previous = new SudokuBoard(board);
            // Perform Iteration
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    SudokuSquare sq = board.squares[i][j];
                    sq.updateValue();
                    // Remove possible values if value is known
                    if (sq.value != -1) {
                        // Rows
                        TileIndex[] rows = board.getRow(i, j);
                        for (TileIndex index : rows) {
                            board.squares[index.x][index.y].removeValue(sq.value);
                        }
                        // Columns
                        TileIndex[] columns = board.getColumn(i, j);
                        for (TileIndex index : columns) {
                            board.squares[index.x][index.y].removeValue(sq.value);
                        }
                        // Squares
                        TileIndex[] squares = board.getSquare(i, j);
                        for (TileIndex index : squares) {
                            board.squares[index.x][index.y].removeValue(sq.value);
                        }
                    }
                    else {
                        // Set value if only possible in row / column / square
                        boolean only = true;
                        for (Integer integer : sq.possible) {
                            if (sq.possible.size() > 1) {
                                // Rows
                                TileIndex[] rows = board.getRow(i, j);
                                for (TileIndex index : rows) {
                                    if (board.squares[index.x][index.y].possible.contains(integer)) {
                                        only = false;
                                    }
                                }
                                if (only) {
                                    sq.setToValue(integer);
                                }
                                only = true;
                                // Columns
                                TileIndex[] columns = board.getColumn(i, j);
                                for (TileIndex index : columns) {
                                    if (board.squares[index.x][index.y].possible.contains(integer)) {
                                        only = false;
                                    }
                                }
                                if (only && sq.possible.size() > 1) {
                                    sq.setToValue(integer);
                                }
                                // Squares
                                TileIndex[] squares = board.getSquare(i, j);
                                for (TileIndex index : squares) {
                                    if (board.squares[index.x][index.y].possible.contains(integer)) {
                                        only = false;
                                    }
                                }
                                if (only && sq.possible.size() > 1) {
                                    sq.setToValue(integer);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (board.isValid() && board.isFinished()) {
            return board;
        }
        else if (!board.isValid()) {
            return null;
        }
        else {
            // Get smallest square and retrieve variations
            TileIndex randomTile = board.getSmallestRemainingTile();
            for (Integer i : board.squares[randomTile.x][randomTile.y].possible) {
                SudokuBoard toReturn = new SudokuBoard(board);
                toReturn.squares[randomTile.x][randomTile.y].value = i;
                toReturn.squares[randomTile.x][randomTile.y].setToValue(i);
                toReturn = solveSudoku(toReturn);
                if (toReturn != null) {
                    return toReturn;
                }
            }
            return null;
        }
    }
}

class SudokuSquare {
    public int value;
    public List<Integer> possible;
    public SudokuSquare() {
        value = -1;
        possible = new ArrayList<>();
        possible.add(1);
        possible.add(2);
        possible.add(3);
        possible.add(4);
        possible.add(5);
        possible.add(6);
        possible.add(7);
        possible.add(8);
        possible.add(9);
    }
    public SudokuSquare(char x) {
        possible = new ArrayList<>();
        if (x == '.') {
            value = -1;
            possible.add(1);
            possible.add(2);
            possible.add(3);
            possible.add(4);
            possible.add(5);
            possible.add(6);
            possible.add(7);
            possible.add(8);
            possible.add(9);
        }
        else if (x == '1'){
            value = 1;
            possible.add(1);
        }
        else if (x == '2'){
            value = 2;
            possible.add(2);
        }
        else if (x == '3'){
            value = 3;
            possible.add(3);
        }
        else if (x == '4'){
            value = 4;
            possible.add(4);
        }
        else if (x == '5'){
            value = 5;
            possible.add(5);
        }
        else if (x == '6'){
            value = 6;
            possible.add(6);
        }
        else if (x == '7'){
            value = 7;
            possible.add(7);
        }
        else if (x == '8'){
            value = 8;
            possible.add(8);
        }
        else if (x == '9'){
            value = 9;
            possible.add(9);
        }
    }
    public SudokuSquare(SudokuSquare ss) {
        value = ss.value;
        possible = new ArrayList<>();
        possible.addAll(ss.possible);
    }

    @Override
    public String toString() {
        return "SudokuSquare{" +
                "value=" + value +
                ", possible=" + possible +
                '}';
    }

    public boolean has(Integer integer) {
        if (possible.contains(integer)) {
            return true;
        }
        else {
            return false;
        }
    }
    public void updateValue() {
        if (possible.size() == 1) {
            value = possible.get(0);
        }
    }
    public void removeValue(int x) {
        if (x != value) {
            if (possible.contains(x)) {
                possible.remove((Integer) x);
            }
        }
    }
    public void setToValue(int x) {
        value = x;
        possible = new ArrayList<>();
        possible.add(x);
    }
    public boolean equals(SudokuSquare ss) {
        if (this.value != ss.value) {
            return false;
        }
        if (this.possible.size() != ss.possible.size()) {
            return false;
        }
        for (int i = 0; i < possible.size(); i++) {
            if (possible.get(i).intValue() != ss.possible.get(i).intValue()) {
                return false;
            }
        }
        return true;
    }
}
class TileIndex {
    public int x;
    public int y;
    public TileIndex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "TileIndex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean equals(int x, int y) {
        return this.x == x && this.y == y;
    }
}
class SudokuBoard {
    public SudokuSquare[][] squares;
    public boolean equals(SudokuBoard other) {
        if (other == null) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!(squares[i][j].equals(other.squares[i][j]))) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid() {
        HashSet<Integer> values;
        // Rows
        for (SudokuSquare[] row : squares) {
            values = new HashSet<>();
            for (SudokuSquare square : row) {
                if (values.contains(square.value)) {
                    return false;
                }
                else if (square.value != -1) {
                    values.add(square.value);
                }
            }
        }
        // Columns
        for (int i = 0; i < 9; i++) {
            values = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (values.contains(squares[i][j].value)) {
                    return false;
                }
                else if (squares[i][j].value != -1) {
                    values.add(squares[i][j].value);
                }
            }
        }
        // Squares
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
                        if (values.contains(squares[a][b].value)) {
                            return false;
                        }
                        else if (squares[a][b].value != -1){
                            values.add(squares[a][b].value);
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isFinished() {
        for (SudokuSquare[] row : squares) {
            for (SudokuSquare square : row) {
                if (square.value == -1) {
                    return false;
                }
            }
        }
        return true;
    }
    public TileIndex[] getRow(int x, int y) {
        TileIndex[] toReturn = new TileIndex[8];
        int count = 0;
        for (int hor = 0; hor < 9; hor++) {
            if (hor != x) {
                toReturn[count++] = new TileIndex(hor, y);
            }
        }
        return toReturn;
    }
    public TileIndex[] getColumn(int x, int y) {
        TileIndex[] toReturn = new TileIndex[8];
        int count = 0;
        for (int vert = 0; vert < 9; vert++) {
            if (vert != y) {
                toReturn[count++] = new TileIndex(x, vert);
            }
        }
        return toReturn;
    }
    public TileIndex[] getSquare(int x, int y) {
        TileIndex[] toReturn = new TileIndex[8];
        int a = (x / 3) * 3;
        int b = (y / 3) * 3;
        int count = 0;
        for (int c = a; c < a + 3; c++) {
            for (int d = b; d < b + 3; d++) {
                if (c != x || d != y) {
                    toReturn[count++] = new TileIndex(c, d);
                }
            }
        }
        return toReturn;
    }
    public SudokuBoard() {
        squares = new SudokuSquare[9][];
        for (int i = 0; i < 9; i++) {
            SudokuSquare[] row = new SudokuSquare[9];
            for (int j = 0; j < 9; j++) {
                row[j] = new SudokuSquare();
            }
            squares[i] = row;
        }
    }
    public SudokuBoard(SudokuBoard sb) {
        squares = new SudokuSquare[9][];
        for (int i = 0; i < 9; i++) {
            SudokuSquare[] row = new SudokuSquare[9];
            for (int j = 0; j < 9; j++) {
                row[j] = new SudokuSquare(sb.squares[i][j]);
            }
            squares[i] = row;
        }
    }
    public SudokuBoard(char[][] board) {
        squares = new SudokuSquare[9][];
        for (int i = 0; i < 9; i++) {
            SudokuSquare[] row = new SudokuSquare[9];
            for (int j = 0; j < 9; j++) {
                row[j] = new SudokuSquare(board[i][j]);
            }
            squares[i] = row;
        }
    }
    public void getCharRepresentation(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (squares[i][j].value != -1) {
                    board[i][j] = Character.forDigit(squares[i][j].value, 10);
                }
                else {
                    board[i][j] = '.';
                }
            }
        }
    }
    public TileIndex getSmallestRemainingTile() {
        int a = 0;
        int b = 0;
        int size = 10;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (squares[i][j].possible.size() > 1 &&
                        squares[i][j].possible.size() < size) {
                    size = squares[i][j].possible.size();
                    a = i;
                    b = j;
                }
            }
        }
        return new TileIndex(a, b);
    }
}
