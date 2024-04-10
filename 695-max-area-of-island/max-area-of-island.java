class Solution {
    
    int sum=0;
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == 1) {
                    sum=0;
                    int res = helper(grid, i, j);
                    max = Math.max(max, res);

                }
            }
        }
       return max; 
    }

    public int helper(int[][] grid, int r, int c) {

        if(r < 0 || c < 0 || r >= grid.length 
            || c >= grid[0].length || grid[r][c] == 0) {
                return 0;
            }

        if(grid[r][c] == 1){
            grid[r][c] = 0;
            sum += 1;
        }

        helper(grid, r-1, c);
        helper(grid, r+1, c);
        helper(grid, r, c+1);
        helper(grid, r, c-1);

     return sum;   
    }
}