import java.util.HashSet;

public class LC0036_ValidSoduku {
    
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] boxSets = new HashSet[9];

        for(int i = 0; i < 9; i++){
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char cur = board[i][j];

                if(cur == '.') continue;


                if(rowSets[i].contains(cur)){
                    return false;
                }
                rowSets[i].add(cur);

                if(colSets[j].contains(cur)){
                    return false;
                }
                colSets[j].add(cur);

                int boxIdx = (i / 3) * 3 + (j / 3);
                if(boxSets[boxIdx].contains(cur)){
                    return false;
                }
                boxSets[boxIdx].add(cur);
            }
        }

        return true;
    }

}
