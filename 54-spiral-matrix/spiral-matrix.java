class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int rs=0, re=matrix.length, cs=0, ce=matrix[0].length;
        int count = re * ce;
        int total = 0;
        List<Integer> result = new ArrayList<>();

        while(rs < re && cs < ce) {

        for(int i=cs; i<ce && total < count; i++) {
            result.add(matrix[rs][i]);
            total++;
        }

        for(int j=rs+1; j<re && total < count; j++) {
            result.add(matrix[j][ce-1]);
            total++;
        }

        for(int k=ce-2; k >=cs && total < count; k--) {
            result.add(matrix[re-1][k]);
            total++;
            }
        
        for(int l=re-2; l>rs && total < count; l--) {
            result.add(matrix[l][rs]);
            total++;
            }
        
            rs++;
            re--;
            cs++;
            ce--;
        }

        return result;
    }
}