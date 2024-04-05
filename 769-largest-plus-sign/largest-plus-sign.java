class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] dp = new int[n][n];
        int res=0;

        for(int[] d : dp) {
            Arrays.fill(d, 1);
        }

        for(int[] m : mines) {
            int x = m[0];
            int y = m[1];
            dp[x][y] = 0;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

               if(dp[i][j] == 1) {

                int order = 1;

                while(true) {

                    int left = j-order;
                    int right = j+order;
                    int up = i-order;
                    int down = i+order;

                    if(left < 0 || right >= n || up < 0 || down >= n
                    || dp[i][left] == 0 || dp[i][right] == 0 ||
                    dp[up][j] == 0 || dp[down][j] == 0) {
                        break;
                    }

                    order++;

                    
                }
                    res = Math.max(res, order);

               }
            }
        }
      return res;  
    }
}