package Array;

class TicTacToe{
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
        diag = 0;
        antiDiag = 0;
    }
    
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if(row == col) diag += toAdd;

        if(col == (n - row - 1)){
            antiDiag += toAdd;
        }

        if(Math.abs(rows[row]) == n || 
        Math.abs(cols[col]) == n ||
        Math.abs(diag) == n ||
        Math.abs(antiDiag) == n
        ){
            return player;
        }

        return 0;
    }
}