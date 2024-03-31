class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                int st = matrix[i][j];
                int ed = matrix[i][n-1];

                if(target >= st && target <= ed) {
                    boolean res = helper(matrix, i, j, m, n, target);
                        if(res) {
                            return true;
                        } else {
                            return false;
                        }
                }
            }
        }
      return false;  
    }

    public boolean helper(int[][] matrix, int rs, int cs, int re, int ce, int target) {

        int st = 0;
        int ed = ce;

        while(st <= ed) {

            int mid = (st + ed)/2;

            if(matrix[rs][mid] == target) {
                return true;
            } else if(matrix[rs][mid] > target) {
                ed = mid-1;
            } else {
                st = mid+1;
            }
        }

      return false;  
    }
}