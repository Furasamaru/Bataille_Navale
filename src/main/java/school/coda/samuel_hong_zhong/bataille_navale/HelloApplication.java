package school.coda.samuel_hong_zhong.bataille_navale;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import school.coda.samuel_hong_zhong.model.Play;

public class HelloApplication extends Application {

    // UI Elements
    private Button[][] playerButtons = new Button[10][10];
    private Button[][] computerButtons = new Button[10][10];
    private Label statusLabel;
    private HBox controls;

    // The Controller
    private Play playController;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        // --- 1. SETUP UI COMPONENTS ---
        statusLabel = new Label();
        statusLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnHoriz = new Button("Horizontal");
        Button btnVert = new Button("Vertical");
        controls = new HBox(10, btnHoriz, btnVert);
        controls.setAlignment(Pos.CENTER);

        // --- 2. INITIALIZE CONTROLLER ---
        // We pass the UI elements so Play can change their colors/text
        playController = new Play(playerButtons, computerButtons, statusLabel, controls);

        // Bind orientation buttons to the controller
        btnHoriz.setOnAction(e -> playController.setHorizontal(true));
        btnVert.setOnAction(e -> playController.setHorizontal(false));

        // --- 3. CREATE BOARDS ---
        GridPane playerGrid = createPlayerGrid();
        GridPane computerGrid = createComputerGrid();

        HBox boardsLayout = new HBox(50);
        boardsLayout.setAlignment(Pos.CENTER);

        VBox playerSide = new VBox(10, new Label("YOUR FLEET"), playerGrid);
        playerSide.setAlignment(Pos.CENTER);

        VBox computerSide = new VBox(10, new Label("ENEMY RADAR"), computerGrid);
        computerSide.setAlignment(Pos.CENTER);

        boardsLayout.getChildren().addAll(playerSide, computerSide);
        root.getChildren().addAll(statusLabel, controls, boardsLayout);

        // Set the initial text
        playController.updateStatusText();

        Scene scene = new Scene(root, 950, 600);
        primaryStage.setTitle("Bataille Navale");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private GridPane createPlayerGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Button cell = new Button();
                cell.setPrefSize(40, 40);
                cell.setStyle("-fx-background-color: #87CEFA; -fx-border-color: #4682B4;");

                final int r = row;
                final int c = col;
                // Tell the controller when a cell is clicked
                cell.setOnAction(e -> playController.handlePlayerCellClick(r, c));

                playerButtons[row][col] = cell;
                grid.add(cell, col, row);
            }
        }
        return grid;
    }

    private GridPane createComputerGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(2);
        grid.setVgap(2);

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                Button cell = new Button();
                cell.setPrefSize(40, 40);
                cell.setStyle("-fx-background-color: #87CEFA; -fx-border-color: #4682B4;");

                final int r = row;
                final int c = col;
                // Tell the controller when a cell is clicked, and pass the button itself so it can be colored
                cell.setOnAction(e -> playController.handleComputerCellClick(r, c, cell));

                computerButtons[row][col] = cell;
                grid.add(cell, col, row);
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        launch(args);
    }
}