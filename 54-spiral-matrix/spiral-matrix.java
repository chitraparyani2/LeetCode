class Solution {
    /**
        00 -> 01 -> 02
        10 -> 11 -> 12
        20 -> 21 -> 22
     */

    public List<Integer> spiralOrder(int[][] matrix) {
     
     List<Integer> result = new ArrayList<>();

     int m = matrix.length;
     int n = matrix[0].length;
     int count = m*n;
     int val = 0;

     int rs=0, cs=0, re=m, ce=n;

    while(rs < re && cs < ce) {

     for(int i=cs; i<ce && val < count; i++) {
        result.add(matrix[rs][i]);
        val++;
     }

     for(int j=rs+1; j<re && val < count; j++) {
        result.add(matrix[j][ce-1]);
        val++;
     }
     
     for(int k=ce-2; k>=cs && val < count; k--) {
        result.add(matrix[re-1][k]);
        val++;
     }

     for(int l=re-2; l>rs && val < count; l--) {
        result.add(matrix[l][rs]);
        val++;
     }

        rs++; re--; cs++; ce--;
    }
        
        return result;  
    }
  
}