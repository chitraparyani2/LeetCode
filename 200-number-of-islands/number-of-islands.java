class Solution {
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {

                if(grid[i][j] == '1') {

                    count++;
                    grid[i][j] = '0';

                    Queue<int[]> queue = new LinkedList();
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()) {

                        int[] res = queue.poll();

                        int x=res[0];
                        int y=res[1];

                        if(x-1 >= 0 && grid[x-1][y] == '1') {
                            grid[x-1][y] = '0';
                            queue.add(new int[]{x-1,y});
                        }

                        if(x+1 < m && grid[x+1][y] == '1') {
                            grid[x+1][y] = '0';
                            queue.add(new int[]{x+1,y});
                        }

                        if(y-1 >= 0 && grid[x][y-1] == '1') {
                            grid[x][y-1] = '0';
                            queue.add(new int[]{x,y-1});
                        }

                        if(y+1 < n && grid[x][y+1] == '1') {
                            grid[x][y+1] = '0';
                            queue.add(new int[]{x,y+1});
                        }
                    }
                }
            }
        }
      return count;  
    }
}