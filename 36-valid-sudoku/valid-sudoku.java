class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!set.contains(board[i][j])) {
                        set.add(board[i][j]);
                    } else {
                        return false;
                    }
                }
            }
            set.clear();
        }

        // col check

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (!set.contains(board[j][i])) {
                        set.add(board[j][i]);
                    } else {
                        return false;
                    }
                }
            }
            set.clear();
        }

        // check box

        int i = 0, j = 0;
        int s1 = 3, s2 = 3, j1 = 0, i1 = 0;

        while (i < 9) {

            while (j < 9) {

                for (i = i1; i < s1; i++) {
                    for (j = j1; j < s2; j++) {

                        if (board[i][j] != '.') {
                            if (!set.contains(board[i][j])) {
                                set.add(board[i][j]);
                            } else {
                                return false;
                            }
                        }

                    }
                }

                set.clear();
                j1 += 3;
                s2 += 3;
            }

            set.clear();
            i1 += 3;
            s1 += 3;
            j1 = 0;
            j=0;
            s2 = 3;

        }

        return true;
    }

}