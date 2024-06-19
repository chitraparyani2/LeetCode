class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            
            Set<Character> rowSet = new HashSet();
            Set<Character> colSet = new HashSet();
            Set<Character> gridSet = new HashSet();

            for(int j=0; j<n; j++) {

                if(board[i][j] != '.' && !rowSet.add(board[i][j])) {
                   return false;
                }

                if(board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }

                int rs =  3*(i/3) + (j/3);
                int cs =  3*(i%3) + (j%3);

                if(board[rs][cs] != '.' && !gridSet.add(board[rs][cs])) {
                    return false;
                }


            }
        }
       return true; 
    }
}