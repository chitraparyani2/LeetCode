class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        boolean row = false;
        boolean col = false;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        System.out.println("m" + m);
        System.out.println("n" + n);

        if(obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i == 0 && obstacleGrid[i][j] == 1) {
                    row = true;
                } else if(j == 0 && obstacleGrid[i][j] == 1) {
                    col = true;
                } else if(i == 0 && !row && obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                } else if(j == 0 && !col && obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                } else if(i != 0 && j != 0 && obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            
            }
        }

      return dp[m-1][n-1];  
    }
}