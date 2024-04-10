class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count=0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == '1') {
                    helper(i, j, grid);
                    count++;
                }
            }
        }
      return count;  
    }

    public void helper(int r, int c, char[][] grid) {

        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length
            || grid[r][c] == '0') {
                return;
            }

        grid[r][c] = '0';

        helper(r+1, c, grid);
        helper(r-1, c, grid);
        helper(r, c+1, grid);
        helper(r, c-1, grid);    
    }
}