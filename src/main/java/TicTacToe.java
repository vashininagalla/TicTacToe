import java.util.Random;
import java.util.Scanner;

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
        int toss = rand.nextInt(2);

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

    // ================= UC3: Accept User Slot Input (1–9) =================
    static int getUserInput() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter a slot number (1-9): ");
        int slot = sc.nextInt();

        return slot;
    }

    // ================= UC4: Convert Slot Number to Row & Column =================
    static int[] convertSlotToIndex(int slot) {

        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;

        return new int[]{row, col};
    }

    public static void main(String[] args) {

        // UC1
        initializeBoard();
        displayBoard();

        // UC2
        toss();

        // UC3
        int userSlot = getUserInput();
        System.out.println("You selected slot: " + userSlot);

        // UC4
        int[] index = convertSlotToIndex(userSlot);
        System.out.println("Row: " + index[0] + ", Column: " + index[1]);
    }
}