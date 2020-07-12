package tictactoe;

public class Coordinates {
    int row;
    int column;
    public static final Coordinates NOT_FOUND = new Coordinates(-1,-1);

    Coordinates() {
        this.row = 0;
        this.column = 0;
    }

    Coordinates(int row, int column) {
        this.row = row;
        this.column = column;

    }

    int getRow() {
        return 2 - column;
    }

    int getColumn() {
        return row;
    }

    void setCoordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        Coordinates temp = (Coordinates) obj;
        return temp.column == this.column && temp.row == this.row;
    }

    @Override
    public String toString() {
        return "(" + getRow() + "," + getColumn() +")";
    }
}
