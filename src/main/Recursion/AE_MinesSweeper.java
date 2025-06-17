package Recursion;

class AE_MinesSweeper {
  int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
  int nrow;
  int ncol;
  
  public String[][] revealMinesweeper(String[][] board, int row, int column) {
    // Write your code here.
    if(board[row][column].equals("M")){
      board[row][column] = "X";
      return board;
    }

    nrow = board.length;
    ncol = board[0].length;
    
    int minesAround = 0;

    for(int[] dir : dirs){
      int a = row + dir[0];
      int b = column + dir[1];
      if(a < 0 || a >= nrow || b < 0 || b >= ncol) continue;
      if(board[a][b].equals("M")) minesAround += 1;
    }

    if(minesAround > 0){
      board[row][column] = Integer.toString(minesAround);
      return board;
    }
    else{
      board[row][column] = "0";

      for(int[] dir: dirs){
        int x = row + dir[0];
        int y = column + dir[1];
        if(x < 0 || x >= nrow || y < 0 || y >= ncol) continue;
        if(board[x][y].equals("H")) revealMinesweeper(board, x, y);
      }
    }

    return board;
  }  
}
