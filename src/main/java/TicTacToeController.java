public class TicTacToeController {
    private final TicTacToeModel model;
    private final TicTacToeView view;

    public TicTacToeController(TicTacToeView view) {
        this.view = view;
        this.model = new TicTacToeModel();
    }

    public void handlePlayerMove(int row, int col) {
        if (model.makeMove(row, col)) {
            view.updateButton(row, col, 'X');
            char winner = model.checkWin();
            if (winner == 'X' || winner == 'O' || model.isBoardFull()) {
                endRound(winner);
                return;
            }

            model.computerMove();
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    if (model.getBoard()[i][j] == 'O')
                        view.updateButton(i, j, 'O');

            winner = model.checkWin();
            if (winner == 'X' || winner == 'O' || model.isBoardFull()) {
                endRound(winner);
            }
        }
    }

    private void endRound(char winner) {
        if (winner == 'X') {
            view.updateStatus("Du vann!");
            model.updateScores('X');
        } else if (winner == 'O') {
            view.updateStatus("Datorn vann!");
            model.updateScores('O');
        } else {
            view.updateStatus("Oavgjort!");
        }
        view.updateScore(model.getPlayerScore(), model.getComputerScore());
        model.resetBoard();
        view.resetBoard();
    }
}
