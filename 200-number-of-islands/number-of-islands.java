class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

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

        if(r < 0 || r >= grid.length || c < 0 ||
            c >= grid[0].length || grid[r][c] == '0') {
                return;
            }

            grid[r][c] = '0';

            helper(grid, r-1, c);
            helper(grid, r+1, c);
            helper(grid, r, c-1);
            helper(grid, r, c+1);

    }
}