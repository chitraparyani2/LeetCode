class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] maxsq = new int[m][n];
        int max=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i == 0 || j == 0) {
                    maxsq[i][j] = matrix[i][j] - '0';
                    max = Math.max(max, maxsq[i][j]);
                } else {
                    if(matrix[i][j] != '0') {
                        maxsq[i][j] = matrix[i][j] - '0' + Math.min(maxsq[i-1][j], 
                            Math.min(maxsq[i][j-1], maxsq[i-1][j-1]));
                        max = Math.max(max, maxsq[i][j]);
                    }
                }
            }
        }

      return max*max;  
    }
}