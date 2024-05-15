class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
      return count;  
    }

    public void helper(char[][] grid, int r, int c) {

        if(r < 0 || c < 0 || r>= grid.length || c >= grid[0].length ||
        grid[r][c] == '0') {
            return;
        }

        grid[r][c]='0';

        helper(grid, r+1, c);
        helper(grid, r-1, c);
        helper(grid, r, c+1);
        helper(grid, r, c-1);
    }
}