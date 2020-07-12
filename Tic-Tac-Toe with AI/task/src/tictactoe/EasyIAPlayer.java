package tictactoe;

import java.util.Random;

public class EasyIAPlayer extends Player {
    Random randomGenerator;

    EasyIAPlayer(Table table, char figure) {
        super(table,figure);
        randomGenerator = new Random();
    }

    EasyIAPlayer(char figure) {
        super(figure);
        randomGenerator = new Random();
    }

    @Override
    public Coordinates makeMove() {
        int[] mov = new int[2];
        mov[0] = randomGenerator.nextInt(3);
        mov[1] = randomGenerator.nextInt(3);
        return new Coordinates(mov[0],mov[1]);
    }

    @Override
    public void validateMovement(boolean isOk) {
        if (isOk) {
            System.out.println("Making move level \"easy\"");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " (IA Easy)";
    }
}
