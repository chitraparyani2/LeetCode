class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        Queue<int[]> queue = new LinkedList();

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == '1') {
                    grid[i][j] = '0';
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {

                       // int size = queue.size();

                      //  for(int k=0; k<size; k++) {

                            int[] curr = queue.poll();

                            for(int[] d : dir) {

                                int x = d[0] + curr[0];
                                int y = d[1] + curr[1];

                                if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') {
                                    continue;
                                }

                                grid[x][y] = '0';
                                queue.add(new int[]{x,y});
                            }
                //        }
                    }
                    count++;
                }
            }
        }
      return count;  
    }
}