class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n= grid[0].length;

        int[][] mincount = new int[m][n];

        mincount[0][0] = grid[0][0];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i == 0 && j != 0) {
                    mincount[i][j] = grid[i][j] + mincount[i][j-1];
                } else if(i != 0 && j == 0) {
                    mincount[i][j] = grid[i][j] + mincount[i-1][j];
                } else if(i !=0 && j!=0) {
                    mincount[i][j] = grid[i][j] + 
                    Math.min(mincount[i-1][j],mincount[i][j-1]);
                }
            }
        }

      return mincount[m-1][n-1];  
    }
}