import java.util.Scanner;

public class NQueens {

    // Check if it's safe to place a queen at position (x, y)
    public static boolean isSafe(int[][] arr, int x, int y, int n) {
        // Check the column
        for (int row = 0; row < x; row++) {
            if (arr[row][y] == 1) {
                return false;
            }
        }

        // Check the upper left diagonal
        int row = x;
        int col = y;
        while (row >= 0 && col >= 0) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        // Check the upper right diagonal
        row = x;
        col = y;
        while (row >= 0 && col < n) {
            if (arr[row][col] == 1) {
                return false;
            }
            row--;
            col++;
        }

        return true;
    }

    // Print the chessboard
    public static void printBoard(int[][] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    System.out.print("[Q] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Solve the N-Queens problem using backtracking
    public static void nQueen(int[][] arr, int x, int n) {
        if (x == n) {
            printBoard(arr, n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(arr, x, col, n)) {
                arr[x][col] = 1; // Place the queen
                nQueen(arr, x + 1, n); // Recur to place the rest
                arr[x][col] = 0; // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the size of the board
        System.out.print("Enter the value of n (size of the board): ");
        int n = scanner.nextInt();

        int[][] arr = new int[n][n]; // Create a 2D array for the chessboard

        nQueen(arr, 0, n); // Start solving the N-Queens problem

        System.out.println("--------All possible solutions--------");

        scanner.close(); // Close the scanner to prevent resource leaks
    }
}

/*
 * OUTPUT:
 * 
 * [Q] [ ] [ ] [ ]
 * [ ] [ ] [Q] [ ]
 * [ ] [Q] [ ] [ ]
 * [ ] [ ] [ ] [Q]
 * 
 * [ ] [Q] [ ] [ ]
 * [Q] [ ] [ ] [ ]
 * [ ] [ ] [Q] [ ]
 * [ ] [ ] [ ] [Q]
 * 
 * --------All possible solutions--------
 */
