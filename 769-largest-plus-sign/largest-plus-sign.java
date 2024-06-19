class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        int res = 0;
        for(int[] g : grid) {
            Arrays.fill(g, 1);
        }

        for(int[] m : mines) {
            int x = m[0];
            int y = m[1];

            grid[x][y] = 0;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == 1) {

                    int max = 1;
                    int s = 1;

                    while(i-s >= 0 && i+s < n && j-s >= 0 && j+s < n &&
                        grid[i-s][j] == 1 && grid[i+s][j] == 1 &&
                        grid[i][j-s] == 1 && grid[i][j+s] == 1)  {

                            max++;
                            s++;

                    }

                    res = Math.max(res, max);
                }
            }
        }

      return res;  
    }
}