class Solution {
    public String tictactoe(int[][] moves) {
        
        int[][] grid = new int[3][3];
        int count = 0;

        for(int[] move : moves) {

            int x = move[0];
            int y = move[1];

            if(count % 2 == 0) {
                grid[x][y] = 1;
            } else {
                grid[x][y] = 2;
            }
            count++;
        }

        boolean resA = checkGrid(grid, 1, 3);

        if(resA) {
            return "A";
        }

        boolean resB = checkGrid(grid, 2, 6);

        if(resB) {
            return "B";
        }

        if(count == 9) {
            return "Draw";
        }


        return "Pending";
    }

    public boolean checkGrid(int[][] grid, int val, int target) {

            int total = 0;

            for(int i=0; i<grid.length; i++) {
                total=0;
                for(int j=0; j<grid.length; j++) {

                    if(grid[i][j] == val) {
                        total += grid[i][j];
                    }
                }

                if(total == target) {
                    return true;
                }
            }

            

            for(int i=0; i<grid.length; i++) {
                 total=0;
                for(int j=0; j<grid.length; j++) {

                    if(grid[j][i] == val) {
                        total += grid[j][i];
                    }
                }

                if(total == target) {
                    return true;
                }
            }
             
             total=0;

            for(int i=0; i<grid.length; i++) {

                if(grid[i][i] == val) {
                    total += grid[i][i];
                }

                if(total == target) {
                    return true;
                }
            }

            total=0;
            int k=grid.length-1;
            for(int i=0; i<grid.length; i++) {
                
                if(grid[i][k] == val) {
                    total += grid[i][k];
                    k--;
                }

                if(total == target) {
                    return true;
                }
            }
        return false;
    }
}