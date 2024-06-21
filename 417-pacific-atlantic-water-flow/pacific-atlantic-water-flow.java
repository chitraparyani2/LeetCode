class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i == 0 || j == 0) {
                    helper(i, j, heights, pacific,-1);
                }

                if(i == m-1 || j == n-1) {
                    helper(i, j, heights, atlantic,-1);
                }
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
      return res;  
    }

    public void helper(int r, int c, int[][] h, boolean[][] o, int prev) {

        if(r < 0 || c < 0 || r >= h.length || c >= h[0].length ||
            prev > h[r][c] || o[r][c]) {
                return;
            }

            o[r][c] = true;

            helper(r-1, c, h, o, h[r][c]);
            helper(r+1, c, h, o, h[r][c]);
            helper(r, c-1, h, o, h[r][c]);
            helper(r, c+1, h, o, h[r][c]);
    }
}