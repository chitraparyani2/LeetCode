class Solution {
    public void setZeroes(int[][] matrix) {
        
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        while(row.size() > 0) {

            int r = row.get(0);

            for(int i=0; i<n; i++) {
                matrix[r][i] = 0;
            }

            row.remove((Object)r);
        }

        while(col.size() > 0) {

            int c = col.get(0);

            for(int i=0; i<m; i++) {
                matrix[i][c] = 0;
            }

            col.remove((Object)c);
        }
    }
}