package school.coda.samuel_hong_zhong.model;

public class interactionPlayer {

    private static final int BOARD_SIZE = 10;
    private static final String[] SHIP_TYPES = {"Aircraft Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
    private static final int[] SHIP_SIZES = {5, 4, 3, 3, 2};

    // Logical board to track placed ships
    private String[][] board;
    private int currentShipIndex = 0;
    private boolean isHorizontal = true;

    public interactionPlayer() {
        this.board = new String[BOARD_SIZE][BOARD_SIZE];
    }

    // --- GETTERS & SETTERS ---
    public boolean isHorizontal() { return isHorizontal; }
    public void setHorizontal(boolean horizontal) { isHorizontal = horizontal; }
    public boolean isAllShipsPlaced() { return currentShipIndex >= SHIP_SIZES.length; }
    public String[][] getBoard() { return board; }

    public String getCurrentShipName() {
        if (isAllShipsPlaced()) return "None";
        return SHIP_TYPES[currentShipIndex] + " (Size: " + SHIP_SIZES[currentShipIndex] + ")";
    }

    public int getCurrentShipSize() {
        if (isAllShipsPlaced()) return 0;
        return SHIP_SIZES[currentShipIndex];
    }

    // --- PLACEMENT LOGIC ---
    /**
     * Attempts to place a ship. Returns true if successful, false if invalid.
     */
    public boolean attemptPlacement(int row, int col) {
        if (isAllShipsPlaced()) return false;

        int size = SHIP_SIZES[currentShipIndex];

        // 1. Check if the ship goes out of bounds
        if (isHorizontal) {
            if (col + size > BOARD_SIZE) return false;
        } else {
            if (row + size > BOARD_SIZE) return false;
        }

        // 2. Check if the path overlaps with an existing ship
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                if (board[row][col + i] != null) return false;
            } else {
                if (board[row + i][col] != null) return false;
            }
        }

        // 3. If valid, place the ship on the logical board
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                board[row][col + i] = SHIP_TYPES[currentShipIndex];
            } else {
                board[row + i][col] = SHIP_TYPES[currentShipIndex];
            }
        }

        // Move to the next ship
        currentShipIndex++;
        return true;
    }
}
