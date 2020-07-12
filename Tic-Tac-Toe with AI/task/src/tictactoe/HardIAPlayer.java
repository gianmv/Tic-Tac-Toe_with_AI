package tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HardIAPlayer extends Player {

    protected Player opponent;
    protected Table test;
    List<Coordinates> availableCells;

    HardIAPlayer(Table table, char figure) {
        super(table, figure);
        this.availableCells = new ArrayList<>();
        this.test = new Table(test);
    }

    HardIAPlayer(char figure) {
        super(figure);
        this.availableCells = new ArrayList<>();
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    @Override
    public void setTable(Table t) {
        super.setTable(t);
        this.test = new Table(t);
    }

    @Override
    public Coordinates makeMove() {
        return minimax(this.table,this).getMovement();
    }

    @Override
    public void validateMovement(boolean isOk) {
        if (isOk) {
            System.out.println("Making move level \"hard\"");
        }
    }

    protected boolean wins(Table t, Player player) {
        return t.isXInColumn(player,3) ||
                t.isXInRow(player,3) ||
                t.isXInDiagonal(player,3);
    }

    protected ArrayList<Coordinates> getEmptyCells(Table t) {
        ArrayList<Coordinates> ans = new ArrayList<>();
        for (int i = 0; i < t.getRowSize(); i++) {
            for (int j = 0; j < t.getColumnSize(); j++) {
                Coordinates temp = new Coordinates(i,j);
                if (t.isEmpty(temp)) {
                    ans.add(temp);
                }
            }
        }

        return ans;
    }

    protected Move minimax(Table newBoard, Player player) {
        //I get all the empty cells in the table
        ArrayList<Coordinates> emptyCells = getEmptyCells(newBoard);
        //I check if the IA win, the opponent or is a draw
        if (wins(newBoard, this.opponent)) {
            return new Move(-10, null);
        } else if (wins(newBoard, this)) {
            return new Move(10,null);
        } else if (emptyCells.size() == 0) {
            return new Move(0,null);
        }

        //In this list a will save all the movements that I will do
        LinkedList<Move> moves = new LinkedList<>();

        //We go trough the coordinates in the list empty cell
        for (Coordinates x:
                emptyCells) {
            //I creat a Move object with the actual coordinate
            Move move = new Move(0,x);
            //We emulate a movement in the table to see the next movements
            newBoard.set(x,player);
            //If the player is the IA (this object)
            //I see the next best possible movement of the opponent
            if (player == this) {
                Move result = minimax(newBoard,this.opponent);
                move.setScore(result.getScore());
            } else {
                //Otherwise I see the next best movement of the IA (this object)
                Move result = minimax(newBoard,this);
                move.setScore(result.getScore());
            }

            //I undo the movement
            newBoard.setEmty(x);
            //Save the best movement in the moves list
            moves.push(move);
        }

        //The next step is find the best move according to who is playing,
        //if is the IA we try to maximize the score otherwise we try to minimize
        //due to is the opponent movement
        Move bestMove = null;
        if (player == this) {
            int bestScore = Integer.MIN_VALUE;
            for (Move x:
                    moves) {
                if (x.getScore() > bestScore) {
                    bestMove = x;
                    bestScore = x.getScore();
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (Move x:
                    moves) {
                if (x.getScore() < bestScore) {
                    bestMove = x;
                    bestScore = x.getScore();
                }
            }
        }
        //return the best movement
        return bestMove;
    }
}

//A simple object to manage the minimax
//algorithm
class Move {
    int score;
    Coordinates movement;

    public Move(int score, Coordinates movement) {
        this.score = score;
        this.movement = movement;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Coordinates getMovement() {
        return movement;
    }

    public void setMovement(Coordinates movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "{score=" + this.score + ", coordinates" + this.movement + "}" ;
    }
}
