class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    count++;

                    grid[i][j] = '0';

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()) {

                        int[] temp = queue.poll();

                        int r = temp[0];
                        int c = temp[1];

                        if(r-1 >= 0 && grid[r-1][c] == '1') {
                            grid[r-1][c] = '0';
                            queue.add(new int[]{r-1,c});
                        }

                        if(r+1 < grid.length && grid[r+1][c] == '1') {
                            grid[r+1][c] = '0';
                            queue.add(new int[]{r+1,c});
                        }

                        if(c-1 >= 0 && grid[r][c-1] == '1') {
                            grid[r][c-1] = '0';
                            queue.add(new int[]{r,c-1});
                        }

                        if(c+1 < grid[0].length && grid[r][c+1] == '1') {
                            grid[r][c+1] = '0';
                            queue.add(new int[]{r,c+1});
                        }
                    }
                }
            }
        }
      return count;  
    }
}