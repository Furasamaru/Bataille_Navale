package school.coda.samuel_hong_zhong.model;

public class Player {
    private static final int SIZE = 10;
    private char[][] Grid; // Declare the grid

    public Player() {
        Grid = new char[SIZE][SIZE];
        // Initialize board with empty spaces
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Grid[i][j] = '.';
            }
        }
    }

    public void placeBlock(int x, int y, char block) {
        // Check if coordinates are within bounds
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            Grid[x][y] = block;   // ✅ Now this works!
        } else {
            System.out.println("Coordinates (" + x + ", " + y + ") are out of bounds!");
        }
    }

    public void displayBoard() {
        // Print column numbers
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Print board rows
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(Grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}