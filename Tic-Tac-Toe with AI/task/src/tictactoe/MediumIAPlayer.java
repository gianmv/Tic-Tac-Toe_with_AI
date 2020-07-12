package tictactoe;

import java.util.Random;

import static tictactoe.Coordinates.NOT_FOUND;

public class MediumIAPlayer extends Player {
    Random randomGenerator;
    Player opponent;
    char SPACE;

    MediumIAPlayer(Table table, char figure) {
        super(table, figure);
        randomGenerator = new Random();
        this.SPACE = table.getEmptyFigure();
    }

    MediumIAPlayer(char figure) {
        super(figure);
        randomGenerator = new Random();
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    @Override
    public void setTable(Table t) {
        super.setTable(t);
        this.SPACE = this.table.getEmptyFigure();
    }

    @Override
    public Coordinates makeMove() {
        Coordinates mov = intelligenceMovement(this);
        if (!mov.equals(NOT_FOUND)) {
            return mov;
        }
        mov = intelligenceMovement(this.opponent);
        if (!mov.equals(NOT_FOUND)) {
            return mov;
        }

        int[] movement = new int[2];
        movement[0] = randomGenerator.nextInt(3);
        movement[1] = randomGenerator.nextInt(3);
        return new Coordinates(movement[0], movement[1]);

    }

    protected Coordinates intelligenceMovement(Player p) {
        Coordinates nextMov = NOT_FOUND;
        //Check columns
        for (int i = 0; i < 3; i++) {
            int countColumn = 0;
            for (int j = 0; j < 3; j++) {
                Coordinates coord = new Coordinates(i,j);
                if (this.table.get(coord) == p.getFigure()) {
                    countColumn++;
                } else if (this.table.get(coord) == this.SPACE) {
                    nextMov = coord;
                }
            }
            if (countColumn == 2 && !nextMov.equals(NOT_FOUND)) {
                return nextMov;
            } else {
                nextMov = NOT_FOUND;
            }
        }

        //Check rows
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                Coordinates coord = new Coordinates(j,i);
                if (this.table.get(coord) == p.getFigure()) {
                    count++;
                } else if (this.table.get(coord) == this.SPACE) {
                    nextMov = coord;
                }
            }
            if (count == 2 && !nextMov.equals(NOT_FOUND)) {
                return nextMov;
            } else {
                nextMov = NOT_FOUND;
            }
        }

        //Check Diagonal
        int count = 0;
        Coordinates coor = NOT_FOUND;
        for (int i = 0; i < 3; i++) {
            coor = new Coordinates(i,i);
            if (this.table.get(coor) == p.getFigure()) {
                count++;
            } else if (this.table.get(coor) == this.SPACE) {
                nextMov = coor;
            }
        }

        boolean ans = count == 2 && !nextMov.equals(NOT_FOUND);

        if (ans) {
            return nextMov;
        } else {
            count = 0;
            for (int i = 2; i >= 0; i--) {
                coor = new Coordinates(2 - i,i);
                if (this.table.get(coor) == p.getFigure()) {
                    count++;
                } else if (this.table.get(coor) == this.SPACE) {
                    nextMov = coor;
                }
            }
            return count == 2 && !nextMov.equals(NOT_FOUND) ? nextMov : NOT_FOUND;
        }
    }

    @Override
    public void validateMovement(boolean isOk) {
        if (isOk) {
            System.out.println("Making move level \"medium\"");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "(IA medium)";
    }
}

