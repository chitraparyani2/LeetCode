class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        int ans = 0;

        for(int[] g : grid) {
            Arrays.fill(g, 1);
        }

        for(int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];

            grid[x][y] = 0;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    int res = helper(grid, i, j);
                    ans = Math.max(ans, res);
                }
            }
        }
      return ans;  
    }

    public int helper(int[][] grid, int r, int c) {

        int s = 1;
        int ans = 1;
        while(r-s >= 0 && r+s < grid.length &&
                c-s >= 0 && c+s < grid[0].length) {

                    if(grid[r-s][c] == 1 && grid[r+s][c] == 1 &&
                        grid[r][c-s] == 1 && grid[r][c+s] == 1) {
                            ans++;
                            s++;
                        } else {
                            break;
                        }
                }

      return ans;          
    }
}