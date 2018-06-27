package filipenko.planC;

public class Deck {

    public static final int BLACK = 1;
    public static final int WHITE = -1;
    public static final int EMPTY = 0;

    public static final int WHITE_QUEEN = -2;
    public static final int BLACK_QUEEN = 2;


    private int[][] field = new int[][]{
            {WHITE, EMPTY, WHITE, EMPTY, WHITE, EMPTY, WHITE, EMPTY},
            {EMPTY, WHITE, EMPTY, WHITE, EMPTY, WHITE, EMPTY, WHITE},
            {WHITE, EMPTY, WHITE, EMPTY, WHITE, EMPTY, WHITE, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
            {EMPTY, BLACK, EMPTY, BLACK, EMPTY, BLACK, EMPTY, BLACK},
            {BLACK, EMPTY, BLACK, EMPTY, BLACK, EMPTY, BLACK, EMPTY},
            {EMPTY, BLACK, EMPTY, BLACK, EMPTY, BLACK, EMPTY, BLACK}
    };

    public int get(int x, int y) {
        return field[y][x];
    }

    public void moveChip(int x1, int y1, int x2, int y2) {
        int tmp = field[y1][x1];
        field[y1][x1] = field[y2][x2];
        field[y2][x2] = tmp;
        if (field[y2][x2] == 1 && y2 == 0 ||
                field[y2][x2] == -1 && y2 == 7)
            becameQueen(x2, y2);
    }

    public void delete(int x, int y) {
        field[y][x] = 0;
    }

    private void becameQueen(int x, int y) {
        if (field[y][x] == 1)
            field[y][x] = BLACK_QUEEN;
        else if (field[y][x] == -1)
            field[y][x] = WHITE_QUEEN;
    }
}
