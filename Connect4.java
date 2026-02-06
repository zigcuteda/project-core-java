import java.util.Scanner;

public class Connect4 {

    static final int R = 6, C = 7;
    static final char E = '.', X = 'X', O = 'O';

    static char[][] board = new char[R][C];
    static String p1, p2;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter name for Player 1 (X): ");
        p1 = sc.nextLine().trim();

        System.out.print("Enter name for Player 2 (O): ");
        p2 = sc.nextLine().trim();

        while (true) {
            initBoard();
            char current = X;
            printBoard();

            while (true) {
                System.out.print(
                    getName(current) + " (" + current + 
                    ") enter column (1-7) or Q to quit: "
                );

                String input = sc.nextLine().trim();

                // Quit handling
                if (input.equalsIgnoreCase("q")) {
                    char other = (current == X) ? O : X;

                    System.out.print(
                        getName(other) + 
                        ", press Y to agree quitting, any other key to continue: "
                    );

                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        System.out.print(
                            "Press Y to play again, any other key to quit: "
                        );

                        if (sc.nextLine().equalsIgnoreCase("y")) {
                            initBoard();
                            current = X;
                            printBoard();
                            continue;
                        }
                        return;
                    }

                    System.out.println("Quit denied.");
                    continue;
                }

                int col;
                try {
                    col = Integer.parseInt(input) - 1;
                } catch (Exception e) {
                    System.out.println("Invalid input.");
                    continue;
                }

                if (col < 0 || col >= C || !drop(col, current)) {
                    System.out.println("Invalid move.");
                    continue;
                }

                printBoard();

                if (checkWin(current) || isFull()) {
                    System.out.println(
                        checkWin(current)
                            ? getName(current) + " wins!"
                            : "The game is a draw."
                    );

                    System.out.print(
                        "Press Y to play again, any other key to quit: "
                    );

                    if (sc.nextLine().equalsIgnoreCase("y")) {
                        initBoard();
                        current = X;
                        printBoard();
                        continue;
                    }
                    return;
                }

                current = (current == X) ? O : X;
            }
        }
    }

    // ---------- Utility Methods ----------

    static String getName(char player) {
        return (player == X) ? p1 : p2;
    }

    static void initBoard() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = E;
            }
        }
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < R; i++) {
            System.out.print("|");
            for (int j = 0; j < C; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
        }

        System.out.print(" ");
        for (int i = 1; i <= C; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println("\n");
    }

    static boolean drop(int col, char player) {
        for (int r = R - 1; r >= 0; r--) {
            if (board[r][col] == E) {
                board[r][col] = player;
                return true;
            }
        }
        return false;
    }

    static boolean checkWin(char p) {

        // Horizontal
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C - 3; c++) {
                if (board[r][c] == p &&
                    board[r][c + 1] == p &&
                    board[r][c + 2] == p &&
                    board[r][c + 3] == p)
                    return true;
            }
        }

        // Vertical
        for (int r = 0; r < R - 3; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == p &&
                    board[r + 1][c] == p &&
                    board[r + 2][c] == p &&
                    board[r + 3][c] == p)
                    return true;
            }
        }

        // Diagonal (down-right)
        for (int r = 0; r < R - 3; r++) {
            for (int c = 0; c < C - 3; c++) {
                if (board[r][c] == p &&
                    board[r + 1][c + 1] == p &&
                    board[r + 2][c + 2] == p &&
                    board[r + 3][c + 3] == p)
                    return true;
            }
        }

        // Diagonal (up-right)
        for (int r = 3; r < R; r++) {
            for (int c = 0; c < C - 3; c++) {
                if (board[r][c] == p &&
                    board[r - 1][c + 1] == p &&
                    board[r - 2][c + 2] == p &&
                    board[r - 3][c + 3] == p)
                    return true;
            }
        }

        return false;
    }

    static boolean isFull() {
        for (int c = 0; c < C; c++) {
            if (board[0][c] == E) {
                return false;
            }
        }
        return true;
    }
}
