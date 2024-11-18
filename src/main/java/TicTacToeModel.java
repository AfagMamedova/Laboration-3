import java.util.Random;

public class TicTacToeModel {
    private final char[][] board;
    private final char currentPlayer;
    private int playerScore;
    private int computerScore;
    private final Random random;

    public TicTacToeModel() {
        board = new char[3][3];
        resetBoard();
        currentPlayer = 'X'; // 'X' är spelarens symbol
        random = new Random();
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    public char checkWin() {
        // Kolla rader och kolumner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        // Kolla diagonaler
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        return ' '; // Ingen vinnare
    }

    public void computerMove() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != ' '); // Hitta en tom plats
        board[row][col] = 'O';
    }

    public void updateScores(char winner) {
        if (winner == 'X') playerScore++;
        else if (winner == 'O') computerScore++;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }
}

