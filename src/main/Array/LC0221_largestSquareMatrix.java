package Array;

class LargestSquareMatrix{

    int nrow;
    int ncol;
    int maxLen = 0;
    public int maximalSquare(char[][] matrix) {
        nrow = matrix.length;
        ncol = matrix[0].length;
        // memo stores maxlen at [x][y]
        Integer[][] memo = new Integer[nrow][ncol];

        dfsHelper(0, 0, matrix, memo);

        return maxLen * maxLen;
    }

    //sol1: Dfs with memo, Time: O(m * n), space: O(M*N)
    public int dfsHelper(int x, int y, char[][] matrix, Integer[][] memo){
        if(x >= nrow || y >= ncol) return 0;
        if(memo[x][y] != null) return memo[x][y];

        int down = dfsHelper(x + 1, y, matrix, memo);
        int right = dfsHelper(x, y + 1, matrix, memo);
        int diag = dfsHelper(x + 1, y + 1, matrix, memo);

        memo[x][y] = 0;
        if(matrix[x][y] == '1'){
            memo[x][y] = 1 + Math.min(down, Math.min(right, diag));
            maxLen = Math.max(maxLen, memo[x][y]);
        }

        return memo[x][y];
    }



    //sol2: Time O((mn)^2) Space: O(1)
    // for every 1 in the matrix, maintain a edge len, starting from 1, increase everytime by 1 if valid
    // go down, right, and right, down, validate '1's
    //ifnot valid reset
    public int maximalSquareSol2(char[][] matrix) {
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int maxSql = 0;

        for(int i = 0; i < nrow; i++){
            for(int j = 0; j < ncol; j++){
                if(matrix[i][j] == '1'){
                    int sqLen = 1;
                    boolean valid = true;

                    while(i + sqLen < nrow && j + sqLen < ncol && valid){
                        for (int k = j; k <= sqLen + j; k++) {
                            if (matrix[i + sqLen][k] == '0') {
                                valid = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqLen + i; k++) {
                            if (matrix[k][j + sqLen] == '0') {
                                valid = false;
                                break;
                            }
                        }
                        
                        if(valid) sqLen++;
                    }
                    maxSql = Math.max(maxSql, sqLen);
                }

                
            }
        }

        return maxSql * maxSql;
    }
}