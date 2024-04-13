class Solution {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        //create binary
        int[][] grid = new int[n][n];

        for(int[] b : grid) {
            Arrays.fill(b, 1);
        }

        for(int[] mine : mines) {
            int x = mine[0];
            int y = mine[1];
            grid[x][y]=0;
        }

        int m1 = grid.length;
        int n1 = grid[0].length;
        int max=0;

        for(int i=0; i<m1; i++) {
            for(int j=0; j<n1; j++) {

                if(grid[i][j] == 1) {
                    int res = 1;
                    max = Math.max(max, res);
                    int x=1;

                    while(i-x >= 0 && i+x < m1 && j-x >=0 && j+x < n1 && grid[i][j] != 0) {

                        if(grid[i][j] == grid[i-x][j] && grid[i][j] == grid[i+x][j] &&
                        grid[i][j] == grid[i][j-x] && grid[i][j] == grid[i][j+x]) {

                            res++;
                            max = Math.max(max, res);

                            x++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
      return max;
    }
}