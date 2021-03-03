import java.util.Scanner;

public class Move {
    private final int row;
    private final int column;
    private final char value;

    Move(int row, int column, char value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getValue() {
        return value;
    }

    public String toString() {
        return "Строка: " + row + ", столбец: " + column + ", значение: " + value;
    }

    public void check() {
        if (row > 3 || row < 1) {
            System.out.println("Введите другое число:");
        }
        if (column > 3 || column < 1) {
            System.out.println("Введите другое число:");
        }
        if (value != 'o') {
            System.out.println("Введите другое значение:");
        }
        if (value != 'x') {
            System.out.println("Введите другое значение:");
        }
        if (row < 4 && row > 0) {
            System.out.println("введите колонку:");
        }
        if (column > 1 && column < 4) {
            System.out.println("Введите знак:");
        }
        if (value == 'o') {
            System.out.println("следующий ход:");
        }
        if (value == 'x') {
            System.out.println("следующий ход:");
        }
    }
}
