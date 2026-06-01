package school.coda.samuel_hong_zhong.model;

// 🚨 Convention de nommage : les noms de classes commencent par une majuscule
public class GameEngine {

    private static final int BOARD_SIZE = 10;
    // 💡 On pourrait utiliser l'enum ShipType
    // Qui encapsule en même temps type et taille de vaisseau
    // Ex. 👇
    // private static final ShipType[] SHIPS_TO_PLACE={ShipType.ENTERPRISE,ShipType.ATAGO,ShipType.SHOUKAKU,ShipType.ST_LOUIS,ShipType.SHOUKAKU};
    private static final String[] SHIP_TYPES = {"Aircraft Carrier", "Battleship", "Cruiser", "Submarine", "Destroyer"};
    private static final int[] SHIP_SIZES = {5, 4, 3, 3, 2};

    // Logical board to track placed ships
    private String[][] board;
    private int currentShipIndex = 0;
    private boolean isHorizontal = true;

    public GameEngine() {
        this.board = new String[BOARD_SIZE][BOARD_SIZE];
    }

    // 💡 Le commentaire n'est pas nécessaire
    // La convention de nommage indique que c'est
    // des getters et setters
    // 💡 Je recommande de mettre les getters et setters en fin de classe car on veut voir le code
    // le plus important (la logique) le plus tôt possible
    // --- GETTERS & SETTERS ---
    public boolean isHorizontal() {
        return isHorizontal;
    }

    // 🚨 nom pourrait être amélioré : setDirection
    // Possibilité d'utiliser une enum pour améliorer
    // la lisibilité Direction.HORIZONTAL, Direction.VERTICAL
    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    public boolean isAllShipsPlaced() {
        return currentShipIndex >= SHIP_SIZES.length;
    }

    public String[][] getBoard() {
        return board;
    }

    public String getCurrentShipName() {
        if (isAllShipsPlaced()) return "None";
        return SHIP_TYPES[currentShipIndex] + " (Size: " + SHIP_SIZES[currentShipIndex] + ")";
    }

    public int getCurrentShipSize() {
        if (isAllShipsPlaced()) return 0;
        return SHIP_SIZES[currentShipIndex];
    }

    // --- PLACEMENT LOGIC ---
    // 🚨 Il y a un implicite qui n'est pas mentionné
    // Le vaisseau qu'on tente de placer est le vaisseau courant

    /**
     * Attempts to place a ship. Returns true if successful, false if invalid.
     */
    public boolean attemptPlacement(int row, int col) {
        if (isAllShipsPlaced()) return false;

        int size = SHIP_SIZES[currentShipIndex];

        // 🤖 commentaire IA ?
        // 1. Check if the ship goes out of bounds
        if (isHorizontal) {
            if (col + size > BOARD_SIZE) return false;
        } else {
            if (row + size > BOARD_SIZE) return false;
        }

        // 🤖 commentaire IA ?
        // 2. Check if the path overlaps with an existing ship
        for (int i = 0; i < size; i++) {
            if (isHorizontal) {
                if (board[row][col + i] != null) return false;
            } else {
                if (board[row + i][col] != null) return false;
            }
        }

        // 🤖 commentaire IA ?
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
