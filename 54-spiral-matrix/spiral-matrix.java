class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int rs=0, re=m, cs=0, ce=n;
        int count=0;
        int total=m*n;

        List<Integer> res = new ArrayList<>();

        while(rs < re && cs < ce) {

            for(int c=cs; c<ce; c++) {
                res.add(matrix[rs][c]);
            }

            for(int r=rs+1; r<re; r++) {
                res.add(matrix[r][ce-1]);
            }

                if(rs != re-1) {
            for(int c=ce-2; c>=cs; c--) {    
                res.add(matrix[re-1][c]);
                }
             }

             if(cs != ce-1) {
            for(int r=re-2; r>rs; r--) {
                res.add(matrix[r][cs]);
                }
            }

            rs++; re--; cs++; ce--;
        }

       return res; 
    }
}