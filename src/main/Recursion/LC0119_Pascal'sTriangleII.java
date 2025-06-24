package Recursion;

import java.util.*;

class PascalTriangleII{
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();

        for(int i = 0; i <= rowIndex; i++){
            ret.add(getNum(rowIndex, i)); // this is only looping within one row: the rowIndex row, from col 0 to col rowIndex
        }

        return ret;
    }

    public int getNum(int rowIdx, int colIdx){
        if(rowIdx == 0 || colIdx == 0 || rowIdx == colIdx) return 1; // topmost, leftmost, rightmost cases

        return getNum(rowIdx - 1, colIdx - 1) + getNum(rowIdx - 1, colIdx);
    }
}