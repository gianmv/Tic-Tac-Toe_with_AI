package tictactoe;

public class Table {
    char X;
    char O;
    char EMPTY;
    char[][] table;

    Table(char[][] t, char x, char o, char empty) {
        this.table = t;
        this.X = x;
        this.O = o;
        this.EMPTY = empty;
    }

    Table(char x, char o, char empty) {
        this.table = new char[][] { {empty,empty,empty},
                {empty,empty,empty},
                {empty,empty,empty}};
        this.X = x;
        this.O = o;
        this.EMPTY = empty;
    }

    Table(Table t) {
        this.X = t.X;
        this.O = t.O;
        this.EMPTY = t.EMPTY;
        this.table = new char[t.table.length][t.table[0].length];
        for (int i = 0; i < t.table.length; i++) {
            for (int j = 0; j < t.table[0].length; j++) {
                this.table[i][j] = t.table[i][j];
            }
        }
    }

    public int getRowSize() {
        return this.table.length;
    }

    public int getColumnSize() {
        return this.table[0].length;
    }

    public void setEmty(Coordinates coord) {
        this.table[coord.getRow()][coord.getColumn()] = this.EMPTY;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public boolean isXInRow(Player player, int number) {
        boolean ans = false;
        for (char[] x : this.table) {
            int count = 0;
            for (char y : x) {
                if (y == player.getFigure()) {
                    count++;
                }
            }
            if (count == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isXInColumn(Player player, int number) {
        for (int i = 0; i < 3; i++) {
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (this.table[j][i] == player.getFigure()) {
                    count++;
                }
            }
            if (count == number) {
                return true;
            }
        }
        return false;
    }

    public boolean isXInDiagonal(Player player, int number) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (this.table[i][i] == player.getFigure()) {
                count++;
            }
        }

        boolean ans = count == number;

        if (ans) {
            return true;
        } else {
            count = 0;
            for (int i = 2; i >= 0; i--) {
                if (this.table[i][2 - i] == player.getFigure()) {
                    count++;
                }
            }
            return count == number;
        }
    }

    public boolean isEmpty(Coordinates coord) {
        return table[coord.getRow()][coord.getColumn()] == this.EMPTY;
    }

    public boolean hasEmptyCells() {
        for (char[] x : this.table) {
            for (char y : x) {
                if (y == this.EMPTY) {
                    return true;
                }
            }
        }

        return false;
    }

    public char getEmptyFigure() {
        return this.EMPTY;
    }

    public char get(Coordinates coord) {
        return table[coord.getRow()][coord.getColumn()];
    }

    public void set(Coordinates coord, Player p) {
        table[coord.getRow()][coord.getColumn()] = p.getFigure();
    }

    @Override
    public String toString() {
        String ans = "---------\n";
        for (int i = 0; i < 3; i++) {
            ans +="| ";
            for (int j = 0; j < 3; j++) {
                ans += table[i][j] + " ";
            }
            ans += "|\n";
        }
        ans += "---------\n";
        return ans;
    }

}


