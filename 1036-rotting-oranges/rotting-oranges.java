class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshOranges = 0, time = 0;
        boolean flag = false;

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList();
        
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == 1) {
                    freshOranges++;
                } else if(grid[i][j] == 2) {
                    
                    queue.offer(new int[]{i,j});
                }
            }
        }

        //System.out.println("freshOranges" + freshOranges);

        if(freshOranges == 0) {
            return time;
        }

        while(!queue.isEmpty()) {

            int size = queue.size();

            for(int i=0; i<size; i++) {

                int[] curr = queue.poll();

                int x = curr[0];
                int y = curr[1];

                grid[x][y] = 0;

                for(int[] d : dir) {

                    int x1 = curr[0] + d[0];
                    int y1 = curr[1] + d[1];

                    if(x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 0) {
                        continue;
                    }

                    if(grid[x1][y1] == 1) {
                        grid[x1][y1] = 0;
                        queue.add(new int[]{x1, y1});
                        freshOranges--;
                    }
                }
            }
                if(!flag) {flag = true;} else {time++;}
                
        }

       // System.out.println("freshOranges" + freshOranges);

      return freshOranges != 0 ? -1 : time;
    }
}