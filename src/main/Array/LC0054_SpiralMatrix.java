package Array;
import java.util.*;
class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        List<Integer> ans = new ArrayList<>();

        while(startRow <= endRow && startCol <= endCol){
            for(int c = startCol; c <= endCol; c++){
                ans.add(matrix[startRow][c]);
            }

            for(int r = startRow + 1; r <= endRow; r++){
                ans.add(matrix[r][endCol]);
            }

            for(int c = endCol - 1; c >= startCol; c--){
                //handle the edge case when there's a single 
                //row in the middle of the matrix.
                //we don't want to double count
                if(startRow == endRow) break;
                ans.add(matrix[endRow][c]);
            }

            for(int r = endRow - 1; r >= startRow + 1;  r--){
                //same, handle the edge case where there's a single 
                //col in the middle of the matrix, avoid double count.
                if(startCol == endCol) break;
                ans.add(matrix[r][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return ans;
    }
}