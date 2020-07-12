package tictactoe;

public abstract class Player {
    protected Table table;
    protected char figure;

    Player(Table table, char figure) {
        this.figure = figure;
        this.table = table;
    }

    Player(char figure) {
        this.figure = figure;
    }

    public abstract Coordinates makeMove();

    public abstract void validateMovement(boolean isOk);

    public char getFigure() {
        return this.figure;
    }

    public void setTable(Table t) {
        this.table = t;
    }

    @Override
    public String toString() {
        return "Player playing with " + this.figure;
    }
}

