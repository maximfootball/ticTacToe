import java.io.Closeable;
import java.util.Scanner;

public class Board {
    private Cell turn;
    private Cell[][] board;
    private int emptyCell;

    Board(int n, int m) {
        this.turn = Cell.X;
        this.board = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
        emptyCell = n * m;
    }
    /*
    int f = 1;

    public void turn() {
        while (f < 10) {
            if (f % 2 == 1) {
                System.out.println("X");
            } else {
                System.out.println("O");

            }
        }
    }*/

    public Cell getTurn() {
        return turn;
    }

    public boolean checkMove(Move m) {
        return board[m.getRow()][m.getColumn()] == Cell.EMPTY;
    }

    //меняет ход
    public void changeTurn() {
        if (turn == Cell.X) {
            turn = Cell.O;
        } else {
            turn = Cell.X;
        }

    }

    public Result makeMove(Move m) {
        if (!checkMove(m)) {
            System.out.println("Ошибка: поле (" + m + ") занято или недоступно!");
            return Result.ERROR;
        }
        board[m.getRow()][m.getColumn()] = turn;
        int count = 1;
        for (int i = m.getRow() + 1; i < board.length; i++) {
            if (board[i][m.getColumn()] != turn) {
                break;
            }
            count++;
        }
        for (int i = m.getRow() - 1; i >= 0; i--) {
            if (board[i][m.getColumn()] != turn) {
                break;
            }
            count++;
        }

        emptyCell -= 1;
        if (emptyCell == 0) {
            return Result.DRAW;
        }
        changeTurn();
        return Result.UNKNOWN;
    }

    public void printBoard() {
        System.out.println("Доска:");
        System.out.print(" ");
        for (int j = 0; j < board[0].length; j++) {
            System.out.print(" " + j);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == Cell.X) {
                    System.out.print("X ");
                } else if (board[i][j] == Cell.O) {
                    System.out.print("O ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();

        }
    }
}
