import java.io.Closeable;
import java.util.Scanner;

public class Board {
    private Cell turn;
    private Cell[][] board;

    Board(int n, int m) {
        this.turn = Cell.X;
        this.board = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = Cell.EMPTY;
            }
        }
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
        //TODO: проверить не победил ли игрок
        changeTurn();
        return Result.UNKNOWN;

    }

    public void printBoard() {
        System.out.print(" ");
        for (int j=0;j<board[0].length;j++){
            System.out.print(j);
        }
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print(i);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]==Cell.X){
                    System.out.print("X");
                }
                else if (board[i][j]==Cell.O) {
                    System.out.print("O");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.println();

        }
    }
}
