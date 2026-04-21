import java.util.*;

public class TicTacToe {
    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initializeBoard();

        while (true) {
            displayBoard();

            System.out.print("Enter row and column (0-2): ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == '-') {
                board[row][col] = 'X';
            } else {
                System.out.println("Invalid move!");
                continue;
            }

            if (checkWinner() == 'X') {
                displayBoard();
                System.out.println("Player wins!");
                break;
            }

            if (isDraw()) {
                displayBoard();
                System.out.println("Draw!");
                break;
            }

            computerMove();

            if (checkWinner() == 'O') {
                displayBoard();
                System.out.println("Computer wins!");
                break;
            }

            if (isDraw()) {
                displayBoard();
                System.out.println("Draw!");
                break;
            }
        }
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = '-';
    }

    static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void computerMove() {
        Random rand = new Random();
        int row, col;

        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (board[row][col] != '-');

        board[row][col] = 'O';
    }

    static char checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-')
                return board[i][0];

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-')
                return board[0][i];
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-')
            return board[0][0];

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-')
            return board[0][2];

        return '-';
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == '-')
                    return false;

        return true;
    }
}
