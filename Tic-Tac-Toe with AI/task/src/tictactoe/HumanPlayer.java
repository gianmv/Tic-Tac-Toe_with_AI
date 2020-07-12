package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    HumanPlayer(Table table, char figure) {
        super(table,figure);
    }

    HumanPlayer(char figure) {
        super(figure);
    }

    @Override
    public Coordinates makeMove() {
        return readPlayerInput();
    }

    @Override
    public void validateMovement(boolean isOk) {
        if (!isOk) {
            System.out.println("The cell is ocupied, choose other");
        }
    }


    protected Coordinates readPlayerInput() {
        String NUMBER_PATTERN = "[\\+-]?\\d+";
        int[] mov = new int[]{-1,-1};
        System.out.print("Enter the coordinates: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] temp = input.split("\\s+");

        boolean isOk = false;
        while (!(mov[0] <= 3 && mov[0] >= 1 && mov[1] <= 3 && mov[1] >= 1)) {
            while (!isOk) {
                if (!temp[0].matches(NUMBER_PATTERN)) {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                    temp = sc.nextLine().split("\\s+");
                }
                if (temp.length < 2) {
                    System.out.println("Need two coordinates");
                    System.out.print("Enter the coordinates: ");
                    temp = sc.nextLine().split("\\s+");
                }

                isOk = temp[0].matches(NUMBER_PATTERN) && temp.length == 2;

            }
            mov[0] = Integer.valueOf(temp[0]);
            mov[1] = Integer.valueOf(temp[1]);
            if (!(mov[0] <= 3 && mov[0] >= 1 && mov[1] <= 3 && mov[1] >= 1)) {
                isOk = false;
                System.out.println("Coordinates should be from 1 to 3!");
                System.out.print("Enter the coordinates: ");
                temp = sc.nextLine().split("\\s+");
            }
        }

        mov[0] = Integer.valueOf(temp[0]);
        mov[1] = Integer.valueOf(temp[1]);



        mov[0] -= 1;
        mov[1] -= 1;

        return new Coordinates(mov[0],mov[1]);
    }

    @Override
    public String toString() {
        return super.toString() + " (Human)";
    }
}

