package tictactoe;

enum GAME_STATE {X_WIN,O_WIN,GAME_NOT_FINISHED,DRAW};

public class TicTacToeGame {
    GAME_STATE gameState;
    Player player1;
    Player player2;
    Table table;

    /*
     * With this constructor the program assumes that the game table is
     * empty, so the initial state is GAME_NOT_FINISHED
     */
    TicTacToeGame(Player player1, Player player2, char empty_char) {
        this.player1 = player1;
        this.player2 = player2;
        this.table = new Table(player1.getFigure(),player2.getFigure(),empty_char);
        this.player1.setTable(this.table);
        this.player2.setTable(this.table);
        gameState = GAME_STATE.GAME_NOT_FINISHED;
    }

    void play() {
        displayTable();
        while (gameState == GAME_STATE.GAME_NOT_FINISHED) {
            if (makeMove(this.player1)) {
                displayTable();
                checkGameState();
                if (makeMove(this.player2)) {
                    displayTable();
                    checkGameState();
                } else {
                    break;
                }
            } else {
                break;
            }

        }

        switch (gameState) {
            case X_WIN:
                System.out.println(player1.getFigure() + " wins");
                break;
            case O_WIN:
                System.out.println(player2.getFigure() + " wins");
                break;
            case DRAW:
                System.out.println("Draw");
        }

    }

    private void checkGameState() {
        boolean player1Win =    this.table.isXInColumn(this.player1,3)||
                this.table.isXInRow(this.player1,3)   ||
                this.table.isXInDiagonal(this.player1,3);

        boolean player2Win =    this.table.isXInColumn(this.player2,3)||
                this.table.isXInRow(this.player2,3)   ||
                this.table.isXInDiagonal(this.player2,3);

        if (player1Win) {
            this.gameState = GAME_STATE.X_WIN;
        } else if (player2Win) {
            this.gameState = GAME_STATE.O_WIN;
        } else if (this.table.hasEmptyCells()) {
            this.gameState = GAME_STATE.GAME_NOT_FINISHED;
        } else {
            this.gameState = GAME_STATE.DRAW;
        }
    }

    private boolean makeMove(Player p) {
        while (gameState == GAME_STATE.GAME_NOT_FINISHED && this.table.hasEmptyCells()) {
            Coordinates coord = p.makeMove();
            if (this.table.isEmpty(coord)) {
                this.table.set(coord,p);
                p.validateMovement(true);
                return true;
            } else {
                p.validateMovement(false);
            }
            this.gameState = table.hasEmptyCells() ? GAME_STATE.GAME_NOT_FINISHED : GAME_STATE.DRAW;
        }

        return false;
    }

    void displayTable() {
        System.out.print(table);
    }

    @Override
    public String toString() {
        return "{Player #1: " + this.player1 + " Player #2" + this.player2 + "Game State: " + gameState + "}";
    }
}
