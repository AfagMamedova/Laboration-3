import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TicTacToeModelTest {

    @Test
    void checkWin() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(0, 0);
        model.makeMove(1, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 1);
        model.makeMove(0, 2);
        assertEquals('X', model.checkWin());
    }

    @Test
    void checkWinCol() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(0, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 0);
        model.makeMove(1, 1);
        model.makeMove(2, 0);
        assertEquals('X', model.checkWin());
    }

    @Test
    void checkDraw() {
        TicTacToeModel model = new TicTacToeModel();
        model.makeMove(0, 0);
        model.computerMove(); // O
        model.makeMove(0, 1);
        model.computerMove(); // O
        model.makeMove(0, 2);
        model.computerMove(); // O
        model.makeMove(1, 0);
        model.computerMove(); // O
        model.makeMove(1, 1);
        model.computerMove(); // O
        model.makeMove(1, 2);
        model.computerMove(); // O
        model.makeMove(2, 0);
        model.computerMove(); // O
        model.makeMove(2, 1);
        model.computerMove(); // O
        model.makeMove(2, 2);

        assertTrue(model.isBoardFull());
        assertEquals(' ', model.checkWin());
    }
}
