package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    public static String[][] board = new String[3][3];
    public static void main(String[] args) {
        // true = X false = O
        boolean turn = true;
        int cond = 0;
        printBoard();
        while (cond != 8) {
            move(turn ? "X" : "O");
            turn = !turn;
            cond++;
        }
        System.out.println("it's a draw young man");
    }

    public static void move(String turn) {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println(turn + ", please enter the row index");
            int row = scan.nextInt() - 1;
            System.out.println(turn + ", please enter the column index");
            int col = scan.nextInt() - 1;
            if (board[row][col] != null) {
                System.out.println("sorry but this position is already taken");
                move(turn);
                return;
            }
            board[row][col] = turn;
            
            if (checkForWin(turn)) {
                System.out.println(turn + ", horray you won!");
                regenerateBoard();
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("just don't do this man");
            move(turn);
            return;
        }
        printBoard();
    }

    public static boolean checkForWin(String turn) {
        for (int i = 0; i < board.length; i++) {
            boolean winner = true;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != turn) {
                    winner = false;
                }
            }
            if (winner) {
                return true;
            }
        }
        for (int i = 0; i < board.length; i++) {
            boolean winner = true;
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != turn) {
                    winner = false;
                }
            }
            if (winner) {
                return true;
            }
        }
        boolean winner = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != turn) {
                winner = false;
            }
        }
        if (winner) {
            return true;
        }
        for (int i = board.length - 1; i > 0; i--) {
            if (board[i][i] != turn) {
                winner = false;
            }
        }
        if (winner) {
            return true;
        }
        return false;

    }

    public static void regenerateBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = null;
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("| " + board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");

    }
}
