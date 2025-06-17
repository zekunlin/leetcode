package Graph;
import java.util.*;

class BoogleBoard {
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static int nrow;
    static int ncol;
    public static List<String> boggleBoard(char[][] board, String[] words) {
        // Write your code here.
        nrow = board.length;
        ncol = board[0].length;
        HashSet<String> ret = new HashSet<>();
        boolean[][] visited = new boolean[nrow][ncol];
        
        for(String word : words){
        char curChar = word.charAt(0);

        for(int x = 0; x < nrow; x++){
            for(int y = 0; y < ncol; y++){
            if(board[x][y] == curChar){
                dfs(x, y, board, 0, word, visited, ret);
                }
            }
            }
        }
        return new ArrayList<String>(ret);
        }
        
    public static void dfs(int x, int y, char[][] board, int idx, String word, boolean[][] visited, HashSet<String> ret){
        if(x < 0 || x >= nrow || y < 0 || y >= ncol || visited[x][y]) return;
        
        if(idx < word.length()){
        if(board[x][y] == word.charAt(idx)){
            visited[x][y] = true;
            if(idx == word.length() - 1) ret.add(word);
            else{
            for(int[] dir: dirs){
                int a = x + dir[0];
                int b = y + dir[1];

                dfs(a, b, board, idx + 1, word, visited, ret);
            }
            }
            visited[x][y] = false;
        }
        }
    }
}
