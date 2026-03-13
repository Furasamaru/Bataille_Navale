package school.coda.samuel_hong_zhong.model;

import javafx.animation.PauseTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.util.Random;

public class Play {

    // Logic Models
    private interactionPlayer playerLogic;
    private String[][] computerBoardLogic;
    private boolean isAttackPhase;
    private boolean end;
    public int playerTouchCount;
    public int comTouchCount;

    //Variables pour le tour par tour
    private boolean isPlayerTurn;
    private boolean[][] computerShots; // Mémorise où l'ordi a déjà tiré
    private Random random;

    // UI Components
    private Button[][] playerButtons;
    private Button[][] computerButtons;
    private Label statusLabel;
    private HBox controls;

    public Play(Button[][] playerButtons, Button[][] computerButtons, Label statusLabel, HBox controls) {
        this.playerLogic = new interactionPlayer();
        this.playerButtons = playerButtons;
        this.computerButtons = computerButtons;
        this.statusLabel = statusLabel;
        this.controls = controls;

        this.isAttackPhase = false;
        this.isPlayerTurn = true; // Le joueur commence toujours
        this.computerShots = new boolean[10][10];
        this.random = new Random();
    }

    // --- BUTTON CONTROLS ---

    public void setHorizontal(boolean isHorizontal) {
        playerLogic.setHorizontal(isHorizontal);
        updateStatusText();
    }

    public void handlePlayerCellClick(int row, int col) {
        if (isAttackPhase) return;

        int size = playerLogic.getCurrentShipSize();
        boolean isHoriz = playerLogic.isHorizontal();

        if (playerLogic.attemptPlacement(row, col)) {
            for (int i = 0; i < size; i++) {
                int r = isHoriz ? row : row + i;
                int c = isHoriz ? col + i : col;
                playerButtons[r][c].setStyle("-fx-background-color: #808080; -fx-text-fill: white; -fx-font-weight: bold;");
                playerButtons[r][c].setText("S");
            }

            if (playerLogic.isAllShipsPlaced()) {
                startAttackPhase();
            } else {
                updateStatusText();
            }
        } else {
            statusLabel.setText("Placement invalide ! (" + (isHoriz ? "H" : "V") + ")");
        }
    }

    public void handleComputerCellClick(int row, int col, Button clickedButton) {
        //On empêche le joueur de cliquer si ce n'est pas son tour
        if (!isAttackPhase || !isPlayerTurn) {
            return;
        }

        String cellContent = computerBoardLogic[row][col];

        if (cellContent == null) {
            clickedButton.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #4682B4;");
            clickedButton.setText("O");
            statusLabel.setText("Plouf ! Tu as raté.");
        } else {
            clickedButton.setStyle("-fx-background-color: #FF4500; -fx-text-fill: white; -fx-font-weight: bold;");
            clickedButton.setText("X");
            playerTouchCount = playerTouchCount + 1;
                statusLabel.setText("BOUM ! Tu as touché un bateau non identifié !");

        }
        if (playerTouchCount >= 17){
            end = true;
            return;
        }

        clickedButton.setDisable(true);

        //Fin du tour du joueur, on lance le tour de l'ordinateur
        isPlayerTurn = false;

        // On crée une pause de 1 seconde pour le suspense
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> computerTurn());
        pause.play();
    }

    // ==========================================
    // NOUVEAU : LOGIQUE DE L'ORDINATEUR
    // ==========================================
    private void computerTurn() {
        int row, col;

        // 1. L'ordinateur cherche des coordonnées où il n'a pas encore tiré
        do {
            row = random.nextInt(10);
            col = random.nextInt(10);
        } while (computerShots[row][col]);

        // 2. Il enregistre son tir
        computerShots[row][col] = true;
        Button targetButton = playerButtons[row][col];

        // 3. Il vérifie ton plateau de jeu (via ton PlayerInteraction)
        String[][] playerBoard = playerLogic.getBoard();
        String cellContent = playerBoard[row][col];

        // 4. On met à jour l'affichage
        if (cellContent == null) {
            targetButton.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #4682B4;");
            targetButton.setText("O");
            statusLabel.setText("L'ennemi a raté ! À ton tour.");
        } else {
            targetButton.setStyle("-fx-background-color: #FF4500; -fx-text-fill: white; -fx-font-weight: bold;");
            targetButton.setText("X");
            comTouchCount = comTouchCount + 1;
            statusLabel.setText("Aïe ! L'ennemi a touché ton " + cellContent + " ! À ton tour.");

        }
        if (comTouchCount >= 17) {
            end = true;
        }

        // 5. C'est de nouveau à toi de jouer
        isPlayerTurn = true;
    }



    // --- GAME STATE MANAGEMENT ---

    private void startAttackPhase() {
        isAttackPhase = true;
        controls.setVisible(false);
        controls.setManaged(false);
        computerBoardLogic = RandomPlacement.generateBoard();
        statusLabel.setText("Tous les navires sont en place ! Attaque le radar à droite !");
        statusLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: darkred;");
    }

    public void updateStatusText() {
        if (!playerLogic.isAllShipsPlaced()) {
            String dir = playerLogic.isHorizontal() ? "Horizontal" : "Vertical";
            statusLabel.setText("Place ton " + playerLogic.getCurrentShipName() + " [" + dir + "]");
        }
    }
}