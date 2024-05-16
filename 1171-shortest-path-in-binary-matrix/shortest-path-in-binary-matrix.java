class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) {
            return -1;
        }

        int res = 0;

        Queue<int[]> queue = new LinkedList<>();

        int[][] dirs = {{-1,-1}, {1,1}, {-1,0}, {1,0},
                        {0,-1}, {0,1}, {-1,1}, {1,-1}};
        
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()) {
            
            int size = queue.size();
            res++;

            for(int i=0; i<size; i++) {

                int[] temp = queue.poll();

                int x = temp[0];
                int y = temp[1];

                if(x == m-1 && y == n-1) {
                    return res;
                }

                for(int[] dir : dirs) {

                    int r = x + dir[0];
                    int c = y + dir[1];

                    if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 1) {
                        continue;
                    }

                    grid[r][c] = 1;
                    queue.offer(new int[]{r,c});
                }
            }
        }

      return -1;  
    }
}