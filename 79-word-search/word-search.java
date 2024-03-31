class Solution {
    /**
        Given - board of characters and a string word
        To find - if word exist in the grid
        Soln -              
    */

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(board[i][j] == word.charAt(0)) {

                    boolean res = helper(board, i, j, m, n, word, 0);

                    if(res) {
                        return true;
                    }
                }
            }
        }
      return false;      
    }

    public boolean helper(char[][] board, int rs, int cs, int re, int ce, String w, int st) {

        if(st == w.length()) {
            return true;
        }

        if(rs < 0 || cs < 0 || rs >= re || cs >= ce || 
                board[rs][cs] != w.charAt(st)) {
                    return false;
                }

        char temp = board[rs][cs];
        board[rs][cs] = '#';

        boolean res = helper(board, rs+1, cs, re, ce, w, st+1) ||
        helper(board, rs-1, cs, re, ce, w, st+1) ||
        helper(board, rs, cs+1, re, ce, w, st+1) ||
        helper(board, rs, cs-1, re, ce, w, st+1);

        if(res) {
            return true;
        } 
        board[rs][cs] = temp;

      return false;  
    }
}