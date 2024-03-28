class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];

        int rs=0, cs=0, re=n, ce=n, count=0, total=n*n;

        while(rs < re && cs < ce) {

            for(int c=cs; c<ce && count<total; c++) {
                matrix[rs][c] = ++count;
            }

            for(int r=rs+1; r<re && count < total; r++) {
                matrix[r][ce-1] = ++count;
            }

            for(int c=ce-2; c>=cs && count < total; c--) {
                matrix[re-1][c] = ++count;
                }
            
            for(int r=re-2; r>rs && count < total; r--) {
                matrix[r][rs] = ++count;
                }

            rs++; cs++; re--; ce--;
        }
       return matrix; 
    }
}