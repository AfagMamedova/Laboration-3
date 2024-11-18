import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TicTacToeView extends Application {
    private TicTacToeController controller;
    private Button[][] buttons;
    private Label statusLabel;
    private Label scoreLabel;

    @Override
    public void start(Stage primaryStage) {
        controller = new TicTacToeController(this);

        buttons = new Button[3][3];
        GridPane grid = new GridPane();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(" ");
                button.setMinSize(100, 100);
                final int row = i, col = j;
                button.setOnAction(e -> controller.handlePlayerMove(row, col));
                buttons[i][j] = button;
                grid.add(button, j, i);
            }
        }

        statusLabel = new Label("Välkommen till Tic-Tac-Toe!");
        scoreLabel = new Label("Spelare: 0 | Dator: 0");

        VBox root = new VBox(10, grid, statusLabel, scoreLabel);
        Scene scene = new Scene(root, 300, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.show();
    }

    public void updateButton(int row, int col, char symbol) {
        buttons[row][col].setText(String.valueOf(symbol));
    }

    public void updateStatus(String message) {
        statusLabel.setText(message);
    }

    public void updateScore(int playerScore, int computerScore) {
        scoreLabel.setText("Spelare: " + playerScore + " | Dator: " + computerScore);
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setText(" ");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
