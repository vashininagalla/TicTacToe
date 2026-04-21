import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];

    // ================= UC1: Display Empty Tic-Tac-Toe Board =================
    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    static void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ================= UC2: Toss to Decide First Player and Symbol =================
    static void toss() {
        Random rand = new Random();
        int toss = rand.nextInt(2); // 0 or 1

        String player1 = "Player 1";
        String player2 = "Player 2";

        char player1Symbol, player2Symbol;
        String currentPlayer;

        if (toss == 0) {
            currentPlayer = player1;
            player1Symbol = 'X';
            player2Symbol = 'O';
        } else {
            currentPlayer = player2;
            player1Symbol = 'O';
            player2Symbol = 'X';
        }

        System.out.println("\nToss Result:");
        System.out.println(currentPlayer + " starts first");

        System.out.println("Symbol Assignment:");
        System.out.println(player1 + " = " + player1Symbol);
        System.out.println(player2 + " = " + player2Symbol);
    }

    public static void main(String[] args) {

        // UC1 Execution
        initializeBoard();
        displayBoard();

        // UC2 Execution
        toss();
    }
}