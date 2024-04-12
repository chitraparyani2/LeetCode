class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int rs=0, re=m, cs=0, ce=n;
        int ct=0;
        int t=m*n;

        List<Integer> res = new ArrayList<>();

        while(rs < re && cs < ce) {

            for(int c=cs; c<ce && ct < t; c++) {
                res.add(matrix[rs][c]);
                ct++;
            }

            for(int r=rs+1; r<re && ct < t; r++) {
                res.add(matrix[r][ce-1]);
                ct++;
            }

            for(int c=ce-2; c>=cs && ct < t; c--) {
                res.add(matrix[re-1][c]);
                ct++;
            }

            for(int r=re-2; r>rs && ct < t; r--) {
                res.add(matrix[r][cs]);
                ct++;
            }

            rs++; re--; cs++; ce--;
        }

       return res; 
    }
}