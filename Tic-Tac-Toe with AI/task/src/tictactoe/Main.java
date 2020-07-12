package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Input command: ");
        Scanner console = new Scanner(System.in);

        String[] com = console.nextLine().split("\\s+");
        TicTacToeGame game;
        boolean isOk = true;
        while (isOk) {
            if (com.length == 1) {
                if ("exit".equals(com[0])) {
                    break;
                } else {
                    System.out.println("Bad parameters!");
                    System.out.print("Input command: ");
                    com = console.nextLine().split("\\s+");
                }
            } else if (com.length == 3) {
                switch (com[0]) {
                    case "start":
                        switch (com[1]) {
                            case "user":
                                switch (com[2]) {
                                    case "user":
                                        game = new TicTacToeGame(new HumanPlayer('x'),
                                                new HumanPlayer('O'),' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "easy":
                                        game = new TicTacToeGame(new HumanPlayer('X'),
                                                new EasyIAPlayer('O'),
                                                ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "medium":
                                        HumanPlayer hm = new HumanPlayer('X');
                                        MediumIAPlayer medium = new MediumIAPlayer('O');
                                        medium.setOpponent(hm);
                                        game = new TicTacToeGame(hm, medium, ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "hard":
                                        HumanPlayer hum = new HumanPlayer('X');
                                        HardIAPlayer hard = new HardIAPlayer('O');
                                        hard.setOpponent(hum);
                                        game = new TicTacToeGame(hum,hard,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    default:
                                        System.out.print("Input command: ");
                                        com = console.nextLine().split("\\s+");
                                }
                                break;
                            case "easy":
                                EasyIAPlayer easy;
                                switch (com[2]) {
                                    case "user":
                                        game = new TicTacToeGame(new EasyIAPlayer('x'),
                                                new HumanPlayer('O'),' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "easy":
                                        game = new TicTacToeGame(new EasyIAPlayer('X'),
                                                new EasyIAPlayer('O'),
                                                ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "medium":
                                        easy = new EasyIAPlayer('X');
                                        MediumIAPlayer medium = new MediumIAPlayer('O');
                                        medium.setOpponent(easy);
                                        game = new TicTacToeGame(easy, medium,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "hard":
                                        easy = new EasyIAPlayer('X');
                                        HardIAPlayer hard = new HardIAPlayer('O');
                                        hard.setOpponent(easy);
                                        game = new TicTacToeGame(easy,hard, ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    default:
                                        System.out.print("Input command: ");
                                        com = console.nextLine().split("\\s+");
                                }
                                break;
                            case "medium":
                                MediumIAPlayer medium;
                                switch (com[2]) {
                                    case "user":
                                        medium = new MediumIAPlayer('X');
                                        HumanPlayer hm = new HumanPlayer('O');
                                        medium.setOpponent(hm);
                                        game = new TicTacToeGame(medium, hm,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "easy":
                                        medium = new MediumIAPlayer('X');
                                        easy = new EasyIAPlayer('O');
                                        medium.setOpponent(easy);
                                        game = new TicTacToeGame(medium, easy, ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "medium":
                                        medium = new MediumIAPlayer('X');
                                        MediumIAPlayer oponent = new MediumIAPlayer('O');
                                        medium.setOpponent(oponent);
                                        oponent.setOpponent(medium);
                                        game = new TicTacToeGame(medium, oponent,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "hard":
                                        medium = new MediumIAPlayer('X');
                                        HardIAPlayer hard = new HardIAPlayer('O');
                                        medium.setOpponent(hard);
                                        hard.setOpponent(medium);
                                        game = new TicTacToeGame(medium,hard,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    default:
                                        System.out.print("Input command: ");
                                        com = console.nextLine().split("\\s+");
                                }
                                break;
                            case "hard":
                                HardIAPlayer hard;
                                switch (com[2]) {
                                    case "user":
                                        hard = new HardIAPlayer('X');
                                        HumanPlayer hm = new HumanPlayer('O');
                                        hard.setOpponent(hm);
                                        game = new TicTacToeGame(hard, hm,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "easy":
                                        hard = new HardIAPlayer('X');
                                        easy = new EasyIAPlayer('O');
                                        hard.setOpponent(easy);
                                        game = new TicTacToeGame(hard, easy, ' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "medium":
                                        hard = new HardIAPlayer('X');
                                        medium = new MediumIAPlayer('O');
                                        hard.setOpponent(medium);
                                        medium.setOpponent(hard);
                                        game = new TicTacToeGame(hard, medium,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    case "hard":
                                        hard = new HardIAPlayer('X');
                                        HardIAPlayer oponent = new HardIAPlayer('O');
                                        oponent.setOpponent(hard);
                                        hard.setOpponent(oponent);
                                        game = new TicTacToeGame(hard,oponent,' ');
                                        game.play();
                                        isOk = false;
                                        break;
                                    default:
                                        System.out.print("Input command: ");
                                        com = console.nextLine().split("\\s+");
                                }
                                break;
                            default:
                                System.out.print("Input command: ");
                                com = console.nextLine().split("\\s+");
                        }
                        break;
                    default:
                        System.out.println("Bad parameters!");
                        System.out.print("Input command: ");
                        com = console.nextLine().split("\\s+");
                }
            } else {
                System.out.println("Bad parameters!");
                System.out.print("Input command: ");
                com = console.nextLine().split("\\s+");
            }
        }
    }


}
