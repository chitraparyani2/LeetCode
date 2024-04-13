class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(i==0 || j==0) 
                    helper(heights, i, j, pacific, 0);
                if(i==m-1 || j==n-1) 
                    helper(heights, i, j, atlantic, 0);
                } 
            }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
            }
        }
    }
     return result;  
    }

    public void helper(int[][] grid, int r, int c, boolean[][] arr, int neig) {
        
       if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
       arr[r][c] || grid[r][c] < neig) {
            return;
       }
        arr[r][c] = true;
        
        helper(grid, r-1, c, arr, grid[r][c]);
        helper(grid, r+1, c, arr, grid[r][c]);
        helper(grid, r, c+1, arr, grid[r][c]);
        helper(grid, r, c-1, arr, grid[r][c]);
    }
}